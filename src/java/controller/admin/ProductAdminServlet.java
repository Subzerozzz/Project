/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.admin;

import dal.implement.ProductDAO;
import dal.implement.categoriesDAO;
import entity.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.annotation.MultipartConfig;

@MultipartConfig
public class ProductAdminServlet extends HttpServlet {
    ProductDAO productDao = new ProductDAO();
    categoriesDAO categoriesDao = new categoriesDAO();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //set UTF-8
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        
        //tao session
        HttpSession session = request.getSession();
        
        //lay ra gia tri action
        String action = request.getParameter("action") == null? "" : request.getParameter("action");
        switch (action){
             case "add":
                 addProduct(request);
                 break;
             case "delete":
                 deleteProduct(request);
                 break;
             case "update":
                 updateProduct(request);
                 break;
             default:
                 throw new AssertionError();
         }
        response.sendRedirect("dashboard");
    }

    private void addProduct(HttpServletRequest request) {
        try {
            //get name
            String name = request.getParameter("name");
            //get price
            Double price = Double.parseDouble(request.getParameter("price"));
            //get quantity
            Integer quantity = Integer.parseInt(request.getParameter("quantity"));
            //get category
            Integer category = Integer.parseInt(request.getParameter("category"));
            //get desciption
            String description = request.getParameter("description") == null ? "" : request.getParameter("description");
            //getImage
            
            //Tạo đối tượng Part để có thể đại diện đường link ảnh phía client gửi lên
            Part part = request.getPart("image");
            String imageFile = null;
            //Kiểm tra đối tượng Path
            if(part.getSubmittedFileName() == null ||
                    part.getSubmittedFileName().trim().toString() == "" ||
                    part == null){
                imageFile = null;
            }
            else{
                //Câu lệnh này giúp truy cập vào tài nguyên của Servlet rồi gọi đến 1 thư mục images
                //Tạo ra đường dẫn path lưu ảnh 
                String path = request.getServletContext().getRealPath("/images");
                //Images có thể chưa tồn tại
                //Vậy nên tạo 1 file đại diện cho path nếu chưa tồn tại ta tạo thư mục
                File dir = new File(path);
                if (!dir.exists()) {
                    dir.mkdirs(); 
                }
                
                File image = new File(dir,part.getSubmittedFileName());
                
                part.write(image.getAbsolutePath());
                imageFile = request.getContextPath() + "/images/" + image.getName();
                
            }
            Product newProduct = Product.builder()
                .name(name)
                .category_id(category)
                .description(description)
                .stock_quantity(quantity)
                .price(price)
                .image(imageFile)
                .build();
            
            productDao.insert(newProduct);
                                    
        } catch (NumberFormatException | IOException | ServletException ex) {
            ex.printStackTrace();
        }
        
        
    }

    private void deleteProduct(HttpServletRequest request) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        productDao.deleteById(id);
    }

    private void updateProduct(HttpServletRequest request) {
        try {
            //getId
            Integer id = Integer.parseInt(request.getParameter("id"));
            //get name
            String name = request.getParameter("name");
            //get price
            Double price = Double.parseDouble(request.getParameter("price"));
            //get quantity
            Integer quantity = Integer.parseInt(request.getParameter("quantity"));
            //get category
            Integer category = Integer.parseInt(request.getParameter("category"));
            //get desciption
            String description = request.getParameter("description") == null ? "" : request.getParameter("description");
            //getImage
            
            //Tạo đối tượng Part để có thể đại diện đường link ảnh phía client gửi lên
            Part part = request.getPart("image");
            String imageFile = null;
            //Kiểm tra đối tượng Path
            if(part.getSubmittedFileName() == null ||
                    part.getSubmittedFileName().trim().toString() == "" ||
                    part == null){
                imageFile = null;
            }
            else{
                //Câu lệnh này giúp truy cập vào tài nguyên của Servlet rồi gọi đến 1 thư mục images
                //Tạo ra đường dẫn path lưu ảnh 
                String path = request.getServletContext().getRealPath("/images");
                //Images có thể chưa tồn tại
                //Vậy nên tạo 1 file đại diện cho path nếu chưa tồn tại ta tạo thư mục
                File dir = new File(path);
                if (!dir.exists()) {
                    dir.mkdirs(); 
                }
                
                File image = new File(dir,part.getSubmittedFileName());
                
                part.write(image.getAbsolutePath());
                imageFile = request.getContextPath() + "/images/" + image.getName();
                
            }
            Product newProduct = Product.builder()
                .product_id(id)
                .name(name)
                .category_id(category)
                .description(description)
                .stock_quantity(quantity)
                .price(price)
                .image(imageFile)
                .build();
            
            productDao.updateProductById(newProduct);
                                    
        } catch (NumberFormatException | IOException | ServletException ex) {
            ex.printStackTrace();
        }
        
        
    }
    
    



}
