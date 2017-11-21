package game.servlets;

import game.beans.BullsCows;
import game.beans.UserIdea;
import game.database.service.hibernate.DatabaseH2;
import game.domain.User;
import game.domain.UserStatistic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@WebServlet(name = "UserServlet")
public class UserServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    private Random random = new Random();

    private synchronized String generateValue() {
        List<Integer> values = new ArrayList<>();
        while (values.size() != 4) {
            int a = random.nextInt(10);
            if (!values.contains(a)) {
                values.add(a);
            }
        }
        final StringBuilder value = new StringBuilder();
        values.forEach(value::append);
        return value.toString();
    }


    private synchronized BullsCows compareWithValue(String value, String mainValue) {
        if (value.equals(mainValue)) {
            return new BullsCows(4, 0);
        }
        int b = 0;
        int c = 0;
        char[] array = value.toCharArray();
        char[] generateArray = mainValue.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (mainValue.contains(String.valueOf(array[i]))) {
                c++;
            }
            if (array[i] == generateArray[i]) {
                b++;
            }
        }
        return new BullsCows(b, c - b);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String mainValue = (String) request.getSession().getAttribute("mainValue");
        UserIdea userValues = (UserIdea) request.getSession().getAttribute("userIdea");
        if (mainValue.equals("")) {
            mainValue = generateValue();
            request.getSession().setAttribute("mainValue", mainValue);
            request.getSession().removeAttribute("count");
            request.getSession().removeAttribute("statistic");
        }
        String value = (String) request.getParameter("valueNumb");
        userValues.addValue(value);
        BullsCows bullsCows = compareWithValue(value, mainValue);
        request.getSession().setAttribute("userIdea", userValues);
        request.getSession().setAttribute("bullsCows", bullsCows);
        if (bullsCows.isWin()) {
            request.getSession().setAttribute("count", userValues.size());
            request.getSession().setAttribute("mainValue", "");
            request.getSession().setAttribute("userIdea", new UserIdea());
            request.getSession().setAttribute("bullsCows", new BullsCows());
            User user = (User) request.getSession().getAttribute("user");
            DatabaseH2.addStatistic(new UserStatistic(user.getLogin(), userValues.size()));
            int statistic = DatabaseH2.getStatistics();
            request.getSession().setAttribute("statistic", statistic);
            response.sendRedirect(request.getContextPath() + "/win.jsp");
        } else {
            response.sendRedirect(request.getContextPath() + "/profile.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
