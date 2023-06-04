package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author aalmasri
 */
public class TestServlet extends HttpServlet {
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        // 1
        request.setAttribute("requestObject", "This is a request object");
        
        // 2
        HttpSession session = request.getSession();
        session.setAttribute("sessionObject", "This is a session object");
        
        // 3
        getServletContext().getRequestDispatcher("/WEB-INF/test.jsp").forward(request, response);
    } 

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
    }


}
