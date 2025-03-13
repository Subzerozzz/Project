/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.user;

import constant.CommonConstant;
import dal.implement.CartDAO;
import dal.implement.CartItemDAO;
import entity.Account;
import entity.Cart;
import entity.CartItem;
import entity.Order;
import entity.OrderDetails;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 *
 * @author User
 */
public class PaymentController extends HttpServlet {
    CartDAO cartDao = new CartDAO();
    CartItemDAO cartItemDao = new CartItemDAO();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NewServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //get ve session
        HttpSession session = request.getSession();
        //lay ra accountID tren session
        Account account = (Account) session.getAttribute(CommonConstant.SESSION_ACCOUNT);
        //lay ra cartID theo accountID
        List<Cart> listCart = cartDao.getIdByAccountID(account.getId());
        //1.la da ton tai cart
        if(listCart.size() != 0){
            //lay ra listCartItem
            List<CartItem> listCartItem = cartItemDao.getListCartItemById(listCart.get(0).getId());
            //set listCartItem len session
            session.setAttribute("listCartItem", listCartItem);
        }//2.chua ton tai cart
        else{
            Cart newCart = Cart.builder()
                    .accountId(account.getId())
                    .build();
            cartDao.insert(newCart);
        }
        request.getRequestDispatcher("view/user/payment/cart.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action") == null ? "" : request.getParameter("action");
        switch (action) {
            case "add":
                addProduct(request,response);
                break;
            case "change-quantity":
                changeQuantity(request,response);
                break;
            default:
                throw new AssertionError();
        }
        response.sendRedirect("payment");
    }

    private void addProduct(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
       //get ve productID
       int id = Integer.parseInt(request.getParameter("id"));
       //get ve quantity
       int quantity = Integer.parseInt(request.getParameter("quantity"));
       //get ve Session
       HttpSession session = request.getSession();
       //lay ra tai khoan tren session
       Account account = (Account) session.getAttribute(CommonConstant.SESSION_ACCOUNT);
       //dua vao tai khoan tren session lay ra tai khoan cartID
       List<Cart> listCart = cartDao.getIdByAccountID(account.getId());
       //1.Da co cartID cua TK do
       if(listCart.size() != 0){
           //tao ra newCartItem moi
            CartItem newCartItem = CartItem.builder()
                   .cartID(listCart.get(0).getId())
                   .quantity(quantity)
                   .productID(id)
                   .build();
            cartItemDao.addNewCartItem(newCartItem);
       } //2.Chua co cartID
       else{
           //tao ra cart va them cart vao DB
            Cart newCart = Cart.builder()
                    .accountId(account.getId())
                    .build();
            cartDao.insert(newCart);
            //tao xong thi them cai san pham ben tren vao cai cart vua duoc tao
            List<Cart> list = cartDao.getLatestId();
            //them cartItem vao
            CartItem newCartItem = CartItem.builder()
                   .cartID(list.get(0).getId())
                   .quantity(quantity)
                   .productID(id)
                   .build();
            cartItemDao.addNewCartItem(newCartItem);
       }
       
      
       
       
    }


    private void changeQuantity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }



}
