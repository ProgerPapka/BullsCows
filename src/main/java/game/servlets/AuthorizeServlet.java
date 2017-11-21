package game.servlets;

import game.beans.BullsCows;
import game.beans.UserIdea;
import game.database.service.hibernate.DatabaseH2;
import game.domain.User;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AuthorizeServlet")
public class AuthorizeServlet extends HttpServlet {

    private static Logger logger = Logger.getLogger(AuthorizeServlet.class);

    @Override
    public void init() throws ServletException {
        super.init();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String login = (String) request.getParameter("login");
        String password = (String) request.getParameter("password");
        User user = DatabaseH2.getUser(login);
        if (user != null && user.getPassword().equals(password)) {
            request.getSession().setAttribute("checkAuthorize", true);
            request.getSession().setAttribute("user", user);
            request.getSession().setAttribute("mainValue", "");
            request.getSession().setAttribute("userIdea", new UserIdea());
            request.getSession().setAttribute("bullsCows", new BullsCows());
            response.sendRedirect(request.getContextPath() + "/profile.jsp");
        } else {
            request.getSession().setAttribute("checkAuthorize", false);
            response.sendRedirect(request.getContextPath() + "/hello.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
