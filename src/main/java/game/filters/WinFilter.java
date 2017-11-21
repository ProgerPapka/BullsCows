package game.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "WinFilter", urlPatterns = "/win.jsp")
public class WinFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws ServletException, IOException {
        chain.doFilter(req, resp);
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        Boolean count = (Boolean) request.getSession().getAttribute("count");
        Boolean statistic = (Boolean) request.getSession().getAttribute("statistic");
        if (count == null || statistic == null) {
            response.sendRedirect(request.getContextPath() + "/hello.jsp");
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
