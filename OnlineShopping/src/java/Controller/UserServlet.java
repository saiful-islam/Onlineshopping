/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import onlineShoppingIntegrationPackage.UserControllerRemote;

/**
 *
 * @author Saiful
 */
@WebServlet(name = "UserServlet", urlPatterns = {"/UserServlet"})
public class UserServlet extends HttpServlet {

    @EJB
    private UserControllerRemote userController;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = (String) request.getSession().getAttribute("actionName");
        PrintWriter out = response.getWriter();
        if (action.equalsIgnoreCase("register")) {
            String userName = request.getParameter("inputUserName");
            String password = request.getParameter("inputPassword");
            String email = request.getParameter("inputEMail");
            String role = "user";

            if (userController.IsExists(userName)) {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('User already Esists.');");
                out.println("location='User/RegisterUser.jsp';");
                out.println("</script>");
            } else if (userController.AddUser(userName, password, email, role)) {
                
                request.getRequestDispatcher("Login.jsp").forward(request, response);
            } else {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('User or password incorrect. re enter user name and password again.');");
                out.println("location='User/RegisterUser.jsp';");
                out.println("</script>");
            }
        } else if (action.equalsIgnoreCase("login")) {
            String userName = request.getParameter("inputUserName");
            String password = request.getParameter("inputPassword");
            
            if (userController.IsValidUser(userName, password)) {
                String roleName=userController.GetUserRole(userName);
                request.getSession().setAttribute("userName", userName);
                request.getSession().setAttribute("roleName", roleName);
                request.getRequestDispatcher("Index.jsp").forward(request, response); 
            } else {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('User or password incorrect. re enter user name and password again.');");
                out.println("location='User/Login.jsp';");
                out.println("</script>");
            }
        }else if (action.equalsIgnoreCase("shoppingcart")) {
            String deliveryAddress = request.getParameter("inputDeliveryAddress");
            String ProductIds = request.getParameter("inputProductIds");
            String deliveryDate = request.getParameter("inputDate");
            String phone = request.getParameter("inputPhone");
            
//            if (userController.IsValidUser(userName, password)) {
//                String roleName=userController.GetUserRole(userName);
//                request.getSession().setAttribute("userName", userName);
//                request.getSession().setAttribute("roleName", roleName);
//                request.getRequestDispatcher("Index.jsp").forward(request, response); 
//            } else {
//                out.println("<script type=\"text/javascript\">");
//                out.println("alert('User or password incorrect. re enter user name and password again.');");
//                out.println("location='User/RegisterUser.jsp';");
//                out.println("</script>");
//            }
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
