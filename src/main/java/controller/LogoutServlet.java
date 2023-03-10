package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 先找到当前用户的会话,
        HttpSession session = req.getSession(false);
        if (session == null) {
            // 用户没有登录!! 谈不上注销!
            resp.getWriter().write("当前用户尚未登录! 无法注销!");
            return;
        }
        // 然后把这个用户的会话中的信息给删掉就行了!!
        session.removeAttribute("user");
        resp.sendRedirect("blog_login.html");
    }
}