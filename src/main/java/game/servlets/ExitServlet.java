package game.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ExitServlet")
public class ExitServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getSession().removeAttribute("checkAuthorize");
        request.getSession().removeAttribute("user");
        request.getSession().removeAttribute("mainValue");
        request.getSession().removeAttribute("userIdea");
        request.getSession().removeAttribute("bullsCows");
        request.getSession().removeAttribute("statistic");
        request.getSession().removeAttribute("count");
        response.sendRedirect(request.getContextPath() + "/hello.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
