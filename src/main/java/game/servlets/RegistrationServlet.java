package game.servlets;

import game.database.service.hibernate.DatabaseH2;
import game.domain.User;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegistrationServlet")
public class RegistrationServlet extends HttpServlet {

    private static Logger logger = Logger.getLogger(RegistrationServlet.class);

    @Override
    public void init() throws ServletException {
        super.init();
        DatabaseH2.addUser(new User("admin", "admin"));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("login1");
        User user = DatabaseH2.getUser(name);
        if (user != null) {
            response.sendRedirect(request.getContextPath() + "/hello2.jsp");
        } else {
            String password = request.getParameter("password1");
            DatabaseH2.addUser(new User(name, password));
            String a = request.getContextPath();
            response.sendRedirect(a + "/hello1.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
