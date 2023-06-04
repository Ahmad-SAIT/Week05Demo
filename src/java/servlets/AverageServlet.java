package servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author aalmasri
 */
public class AverageServlet extends HttpServlet {
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        // 1
        HttpSession session = request.getSession();
        
        // 1.1 if reset needed
        String action = request.getParameter("action");
        if(action!=null && action.equals("reset")){
            // 1.2 invalidate
            session.invalidate();
            // 1.3 get a valid session
            session = request.getSession();
        }
        
        
        // 2
        ArrayList<Integer> numbers = (ArrayList<Integer>) session.getAttribute("numbers");
        // 2.1
        if(numbers == null){
            numbers = new ArrayList<>();
        }
        // 3
        if(request.getParameter("num") != null){
            int x = Integer.parseInt(request.getParameter("num"));
            numbers.add(x);
            // 4
            session.setAttribute("numbers", numbers);
        }
        
        // calculate the avg
        int sum = 0;
        for(int n : numbers){
            sum += n;
        }
        if(numbers.size() > 0){
            double avg = sum/numbers.size();
            request.setAttribute("avg", avg);
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/average.jsp")
                .forward(request, response);
    } 

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
    }


}
