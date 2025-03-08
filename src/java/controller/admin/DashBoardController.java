/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.admin;

import constant.CommonConstant;
import dal.implement.ProductDAO;
import dal.implement.categoriesDAO;
import entity.Product;
import entity.categories;
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
public class DashBoardController extends HttpServlet {
    ProductDAO productDao = new ProductDAO();
    categoriesDAO categoriesDao = new categoriesDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Product> listProduct = productDao.findAll();
        List<categories> listCategory = categoriesDao.findAll();
        
        HttpSession session = request.getSession();
        session.setAttribute(CommonConstant.SESSION_PRODUCT, listProduct);
        session.setAttribute(CommonConstant.SESSION_CATEGORY, listCategory);
        
        request.getRequestDispatcher("../view/admin/dashboard.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }



}
