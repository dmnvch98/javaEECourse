package servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "signIn", value = "/signIn")
public class SignInServlet extends AbstractUserServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect("/view/sign_in.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (getUserService().userIsExist(username, password)) {
            req.getSession().setAttribute("username", username);
            req.getSession().setAttribute("password", password);
            resp.sendRedirect("/allUsers");
        } else {
            resp.sendRedirect("/view/sign_in.jsp");
        }
    }
}
