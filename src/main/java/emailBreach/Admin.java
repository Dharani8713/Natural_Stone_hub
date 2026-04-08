package emailBreach;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/admin")
public class Admin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");

        try {
            DBConnection db = new DBConnection("admin_user", "adminpass"); // full privilege
            db.insertLeakedEmail(email);
            db.close();

            request.setAttribute("message", "Leaked email added successfully!");
            RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            throw new ServletException("DB error", e);
        }
    }
}
