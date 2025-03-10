/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.user;

import entity.Order;
import entity.OrderDetails;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 * @author User
 */
public class PaymentController extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
            default:
                throw new AssertionError();
        }
    }

    private void addProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //get ve session
        HttpSession session = request.getSession();
        //get ve id
        int id = Integer.parseInt(request.getParameter("id"));
        //get ve quantity
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        //kiem tra xem cart da có tren session chua
        Order cart = (Order) session.getAttribute("cart");
        if(cart == null){
            cart = new Order();
        }
        //them orderDetails vào cart
        OrderDetails od = OrderDetails.builder()
                .productId(id)
                .quantity(quantity)
                .build();
        addOrderDetailsToOrder(cart,od);
        //chuyen ve get payment
        response.sendRedirect("payment");
    }

    private void addOrderDetailsToOrder(Order cart, OrderDetails od) {
       boolean isAdd = true;
       for(OrderDetails orderDetails : cart.getListOrderDetails()){
           if(orderDetails.getProductId() == od.getProductId()){
               isAdd = false;
               orderDetails.setQuantity(orderDetails.getQuantity()+ od.getQuantity());
           }
       }
       if(isAdd){
           cart.getListOrderDetails().add(od);
       }
       
    }



}
