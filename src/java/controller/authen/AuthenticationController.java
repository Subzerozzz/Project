/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.authen;

import constant.CommonConstant;
import dal.implement.AccountDAO;
import entity.Account;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author User
 */
public class AuthenticationController extends HttpServlet {
    AccountDAO accountDao = new AccountDAO();

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action")== null ? "" : request.getParameter("action");
        String url;
        switch (action) {
            case "logout":
                url = logOut(request, response);
                break;
            case "login":
                url = "view/authen/login.jsp";
                break;
            case "register":
                url = "view/authen/register.jsp";
                break;
            default:
                url = "home";
        }
        request.getRequestDispatcher(url).forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action") == null? "" : request.getParameter("action");
        String url;
        switch (action) {
            case "login":
                url = loginDoPost(request,response);
                break;
            case "register":
                url = register(request,response);
                break;
            default:
                url = "home";
        }
        request.getRequestDispatcher(url).forward(request, response);
    }

    private String loginDoPost(HttpServletRequest request, HttpServletResponse response) {
        //get ve du lieu
        String username = request.getParameter("username") == null ? "" : request.getParameter("username");
        String password = request.getParameter("password") == null ? "" : request.getParameter("password");
        String url ="";
        //check dữ liệu
        Account account = Account.builder()
                .username(username)
                .password(password)
                .build();
        Account accountByFindUserAndPass = accountDao.findByUserNameAndPass(account);
        //check = true => url home
        if(accountByFindUserAndPass != null){
            request.getSession().setAttribute(CommonConstant.SESSION_ACCOUNT, accountByFindUserAndPass);
            url = "home";
        }
        //check = false => url login + notification
        else{
            request.setAttribute("error", "Username or Password Wrong");
            url = "view/authen/login.jsp";
        }
        return url;
    }

    private String logOut(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().removeAttribute(CommonConstant.SESSION_ACCOUNT);
        return "home?action=home";
    }

    private String register(HttpServletRequest request, HttpServletResponse response) {
        String url=null;
        //lấy ra các giá trị mà người dùng gửi lên
        String username = request.getParameter("username").trim();
        String password = request.getParameter("password").trim();
        String email = request.getParameter("email").trim();
        String address = request.getParameter("address").trim();
        
        //kiểm tra xem username tồn tại chưa
        Account account = Account.builder()
                .username(username)
                .build();
        Account accountByFindUsername= accountDao.findByUserName(account);
        
        //neu da ton tai, quay lại trang reigter và báo lỗi
        if(accountByFindUsername != null){
            request.setAttribute("error", "Username existed");
            url = "view/authen/register.jsp";
            
        }else{
            //Đóng thành 1 đối tượng Account
            Account newAccount = Account.builder()
                    .address(address)
                    .username(username)
                    .password(password)
                    .email(email)
                    .build();
            accountDao.insert(newAccount);
            request.getSession().setAttribute(CommonConstant.SESSION_ACCOUNT, newAccount);
            url = "home";
        }

        return url;
    }



}
