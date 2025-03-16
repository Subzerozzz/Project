/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.user;

import constant.CommonConstant;
import dal.implement.CartDAO;
import dal.implement.CartItemDAO;
import dal.implement.OrdersDAO;
import dal.implement.OrderItemDAO;
import entity.Account;
import entity.Cart;
import entity.CartItem;
import entity.Orders;
import entity.OrderItem;
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
public class CheckOutController extends HttpServlet {
    CartDAO cartDao = new CartDAO();
    CartItemDAO cartItemDao = new CartItemDAO();
    OrdersDAO orderDao = new OrdersDAO();
    OrderItemDAO orderItemDao = new OrderItemDAO();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CheckOutController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CheckOutController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //get ve session
        HttpSession session = request.getSession();
        //lay ra accountID dang tren session
        Account account = (Account) session.getAttribute(CommonConstant.SESSION_ACCOUNT);
        //tu accountID lay ra cartId
        List<Cart> list = cartDao.getIdByAccountID(account.getId());
        //tu cartID lay duoc orderID muon nhat
        int cartID = list.get(0).getId();
        List<Orders> listOrder = orderDao.getOrdersIdByCartID(cartID);
        int orderID = listOrder.get(listOrder.size() - 1).getId();
        //tu orderId lay ra OrderItem
        List<OrderItem> listOrderItem = orderItemDao.getProductByOrderID(orderID);
        //set len session
        session.setAttribute("listOrderItem", listOrderItem);
        session.setAttribute("totalPrice", listOrder.get(listOrder.size() - 1).getTotalPrice());
        request.getRequestDispatcher("view/user/payment/check_out.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "check-out":
                checkOut(request,response);
                break;
            default:
                throw new AssertionError();
        }
        response.sendRedirect("checkout");
    }


    private void checkOut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //get ve session
        HttpSession session = request.getSession();
        //get ve accountID
        Account account = (Account) session.getAttribute(CommonConstant.SESSION_ACCOUNT);
        //get ve cartID cua accountID do
        List<Cart> listCart = cartDao.getIdByAccountID(account.getId());
        //get ve totalPrice
        double totalPrice = Double.parseDouble(request.getParameter("total-price"));
        //tao 1 doi tuong order 
        Orders newOrder = Orders.builder()
                .cartId(listCart.get(0).getId())
                .totalPrice(totalPrice)
                .build();
        //them order do vao DB
        orderDao.insert(newOrder);
        //get ve 1 list cartItem de dua vao order moi tao
        List<CartItem> listCartItem = cartItemDao.getListCartItemById(listCart.get(0).getId());
        //get cai OrderID mới nhất
        List<Orders> latestOrderID = orderDao.getLatestId();
        for(CartItem cart : listCartItem){
            OrderItem newOrderItem = OrderItem.builder()
                    .orderID(latestOrderID.get(0).getId())
                    .productID(cart.getProductID())
                    .quantity(cart.getQuantity())
                    .build();
            orderItemDao.insert(newOrderItem);
            //xoa cac san pham do trong cartItem vi da dong thanh don hang
            cartItemDao.deleteProductByID(cart.getId());
        }
        
        
    }

//    private void checkOut(HttpServletRequest request, HttpServletResponse response) throws IOException {
//       PrintWriter out = response.getWriter();
//       out.println("<h1>Servlet NewServlet at " + request.getContextPath() + "</h1>");
//    }

}
