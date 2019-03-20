
//For Exam #2 (JSP to Servlet or Servlet to JSP)
//Loan Amount 5 -----STUDY!!!!!!!!!!!!
//This is basically Loan Amount 4 changed from JSP to Servlet.
package loanamount5;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "LoanAmount5", urlPatterns = {"/LoanAmount5"})
public class LoanAmount5 extends HttpServlet 
{


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        
        String TitleArray[] = new String[5];
        TitleArray[0] = "Payment Number";
        TitleArray[1] = "Payment Amount";
        TitleArray[2] = "Interest";
        TitleArray[3] = "Prinicpal Part";
        TitleArray[4] = "Balance";
            
        double P = Double.parseDouble(request.getParameter("P"));
        double R = Double.parseDouble(request.getParameter("R"));
        double T = Double.parseDouble(request.getParameter("T"));
        double N = Double.parseDouble(request.getParameter("N"));
        double A = P * R / (N * (1 - Math.pow(1 + R / N, -1 * N * T)));
        double B = P;
        
        try (PrintWriter out = response.getWriter()) 
        {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            
            out.println("<head>");
            out.println("<title>Servlet Loan Amount 5</title>");            
            out.println("</head>");
            
            out.println("<body>");
            
            out.println("<h1> Loan Amount 5 </h1>");
            
            
            
            out.println("<table>");
            
            out.println("<tr>");
            out.println("<td> Interest Rate </td>");
            out.println("<td> <input type='text' name='R' value= " + R + "> </td>");
           
            out.println("<td> Amount of Time </td>");
            out.println("<td> <input type='text' name='T' value= " + T + "> </td>");
            out.println("</tr>");
            
            out.println("<tr>");
            out.println("<td> Compound </td>");
            out.println("<td> <input type='text' name='R' value= " + N + "> </td>");
           
            out.println("<td> Principal </td>");
            out.println("<td> <input type='text' name='T' value= " + P + "> </td>");
            out.println("</tr>");
            
            out.println("<tr>");
            out.println("<td> Payment Amount </td>");
            out.println("<td> <input type='text' name='R' value= " + A + "> </td>");
            out.println("</tr>");
            out.println("</table>");
            
            out.println("");
            
            out.println("<table border = 2>");
            for (int j = 0; j < 5; j++)
            {
                out.println("<th>" + TitleArray[j] + "</th>");
            }
            
            for (int i = 1; i <= N*T; i++)
            {
                double I = B * R /N;
                double PrincipalPart = A - I;
                B = B - PrincipalPart;
                
                out.println("<tr>");
                
                out.println("<td>" + i + "</td>");
                out.println("<td>" + A + "</td>");
                out.println("<td>" + I + "</td>");
                out.println("<td>" + PrincipalPart + "</td>");
                out.println("<td>" + B + "</td>");
                
                out.println("</tr>");
            }
          
            out.println("</table>");
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
