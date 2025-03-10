/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.homepage;

import constant.CommonConstant;
import dal.implement.ProductDAO;
import entity.PageControl;
import entity.Product;
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
public class HomeController extends HttpServlet {

    ProductDAO productDao = new ProductDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HomeController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HomeController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("listProduct", productDao.findAll());
        String action = request.getParameter("action") == null ? "" : request.getParameter("action");
        switch (action) {
            case "":
            case "home":
                //14 là stt BestSeller trong DB
                List<Product> listBestSeller = productDao.getDataByCategoryId("14");
                session.setAttribute("listBestSeller", listBestSeller);
                request.getRequestDispatcher("view/homepage/home.jsp").forward(request, response);
                break;
            case "men":
                //lấy ra page
                String pageMen = request.getParameter("page") == null ? "1" : request.getParameter("page");
                //set pagination
                PageControl pageControlMen = setPageControl(productDao.getDataByCategoryId("15").size(),request,action);
                //end set pagination
                List<Product> listMen = getDataByGender("15",pageMen);//15 la stt quan ao nam trong DB
                session.setAttribute("listMen", listMen);
                session.setAttribute("pageControlMen", pageControlMen);
                request.getRequestDispatcher("view/homepage/shop-men.jsp").forward(request, response);
                break;
            case "women":
                String pageWomen = request.getParameter("page") == null ? "1" : request.getParameter("page");
                List<Product> listWomen = getDataByGender("16",pageWomen);//16 la stt quan ao nam trong DB
                //set được cả pagination
                PageControl pageControlWomen = setPageControl(productDao.getDataByCategoryId("16").size(),request,action);
                //end set pagination
                session.setAttribute("listWomen", listWomen);
                session.setAttribute("pageControlWomen", pageControlWomen);
                request.getRequestDispatcher("view/homepage/shop-women.jsp").forward(request, response);
                break;
            case "search":
                String pageSearch = request.getParameter("page") == null ? "1" : request.getParameter("page");
                String keyword = request.getParameter("keyword");
                List<Product> listSearch = getDataBySearch(keyword);
                //set được cả pagination
                PageControl pageControlSearch = setPageControl(listSearch.size(),request,action);
                //end set pagination
                session.setAttribute("listSearch", listSearch);
                session.setAttribute("pageControlSearch", pageControlSearch);
                request.getRequestDispatcher("view/homepage/shop-search.jsp").forward(request, response);
                break;
            default:

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("home");
    }

    private List<Product> getDataByGender(String action, String page) {
        List<Product> list = productDao.getDataByCategoryIdForPagination(action,page);
        return list;
    }
    
    private List<Product> getDataBySearch(String keyword) {
        List<Product> list = productDao.getDataBySearch(keyword);
        return list;
    }

    private PageControl setPageControl(int totalRecord,HttpServletRequest request,String action) {
       PageControl pageControl = new PageControl();
       //set totalRecord
       pageControl.setTotalRecord(totalRecord);
       //set totalPage
       CommonConstant commonConstant = new CommonConstant();
       int totalPage = totalRecord % commonConstant.PRO_PER_PAGE == 0 ? 
                        (totalRecord / commonConstant.PRO_PER_PAGE ):
                         (totalRecord / commonConstant.PRO_PER_PAGE ) + 1;
       pageControl.setTotalPage(totalPage);
       //set currentPage
       String pageRaw = request.getParameter("page");
       int page;
        try {
            page = Integer.parseInt(pageRaw);
            if(page < 0){
                page = 1;
            }
        } catch (Exception e) {
            //neu pageRaw khong hop le cho page = 1
            page = 1;
        }
       pageControl.setCurrentPage(page);
       
       //setUrlPattern
       String requestURL = request.getRequestURL().toString();
       pageControl.setUrlPattern(requestURL + "?" + "action="+ action + "&");
       
       return pageControl;
    }




}
