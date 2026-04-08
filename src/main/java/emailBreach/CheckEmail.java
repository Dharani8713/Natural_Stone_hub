package emailBreach;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/checkEmail")
public class CheckEmail extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");

        try {
            DBConnection db = new DBConnection("app_user", "password"); // read-only user
            boolean isLeaked = db.isEmailLeaked(email);
            db.close();

            request.setAttribute("email", email);
            request.setAttribute("isLeaked", isLeaked);
            RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            throw new ServletException("DB error", e);
        }
    }
}
