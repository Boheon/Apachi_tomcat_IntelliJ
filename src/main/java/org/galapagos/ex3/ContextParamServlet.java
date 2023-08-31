package org.galapagos.ex3;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
    urlPatterns = {"/contextparam"},
        initParams = {
            @WebInitParam(name = "pathDir", value = "c:/temp", description = "파일업로드 경로"),
                @WebInitParam(name = "userId", value = "hong")
        }
)
public class ContextParamServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext sc = getServletContext();

        String driver = sc.getInitParameter("driver");
        String dburl = sc.getInitParameter("dburl");
        String username = sc.getInitParameter("username");
        String password = sc.getInitParameter("password");

        System.out.println(driver);
        System.out.println(dburl);
        System.out.println(username);
        System.out.println(password);

    }
}
