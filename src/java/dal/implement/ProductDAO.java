/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal.implement;

import constant.CommonConstant;
import dal.GenericDAO;
import entity.Product;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author User
 */
public class ProductDAO extends GenericDAO<Product> {
    CommonConstant commonConstant = new CommonConstant();

    @Override
    public List<Product> findAll() {
       return queryGenericDAO(Product.class);
    }
    
    @Override
    public int insert(Product t) {
        return insertGenericDAO(t);
    }
    
    public List<Product> getDataByCategoryId(String id){
        //Chuan bị câu lệnh sql
        String sql = "select * from dbo.Product as P\n" +
                        "where P.category_id = ?";
        //Chuẩn bị parameterMap
        parameterMap = new LinkedHashMap<>();
        parameterMap.put("P.category_id", id);
        //Lấy dữ liệu
        List<Product> list = queryGenericDAO(Product.class , sql, parameterMap);
        return list;
    }
    
    public List<Product> getProductById(String id) {
        //Chuan bị câu lệnh sql
        String sql = "select * from dbo.Product as P\n" +
                        "where P.product_id = ?";
                
        //Chuẩn bị parameterMap
        parameterMap = new LinkedHashMap<>();
        parameterMap.put("P.product_id", id);
        //Lấy dữ liệu
        List<Product> list = queryGenericDAO(Product.class , sql, parameterMap);
        return list;
    }

    public List<Product> getDataBySearch(String keyword) {
       String sql = "SELECT * FROM Product WHERE name LIKE ?";
       //Chuẩn bị PrameterMap
       parameterMap = new LinkedHashMap<>();
       parameterMap.put("name","%" + keyword + "%");
       
       List<Product> list = queryGenericDAO(Product.class , sql, parameterMap);
       return list;
    }
    
    public List<Product> getDataByCategoryIdForPagination(String id, String pageRaw) {
        int page=Integer.parseInt(pageRaw);
        //Chuan bị câu lệnh sql
        String sql = "SELECT * \n" +
                    "FROM dbo.Product as P \n" +
                    "Where P.category_id=?\n" +
                    "order by P.product_id \n" +
                    "offset ? rows\n" +
                    "fetch next ? rows only";
        //Chuẩn bị parameterMap
        parameterMap = new LinkedHashMap<>();
        parameterMap.put("P.category_id", id);
        parameterMap.put("offset", (page - 1) * commonConstant.PRO_PER_PAGE);
        parameterMap.put("fetch", commonConstant.PRO_PER_PAGE);
        //Lấy dữ liệu
        List<Product> list = queryGenericDAO(Product.class , sql, parameterMap);
        return list;
    }
    
           
    public boolean deleteById(Integer id) {
        String sql = "delete from dbo.Product\n" +
                        "where product_id = ?";
        parameterMap = new LinkedHashMap<>();
        parameterMap.put("id", id);
        
        return deleteGenericDAO(sql, parameterMap);
    }

    public void updateProductById(Product newProduct) {
        String sql = "UPDATE [dbo].[Product]\n" +
                        "SET [name]=?\n" +
                        ",[description]=?\n" +
                        ",[price]=?\n" +
                        ",[image]=?\n" +
                        ",[stock_quantity]=?\n" +
                        ",[category_id]=?\n" +
                        "  WHERE product_id = ?";
        parameterMap = new LinkedHashMap<>();
        parameterMap.put("name",newProduct.getName());
        parameterMap.put("description",newProduct.getDescription());
        parameterMap.put("price",newProduct.getPrice());
        parameterMap.put("image",newProduct.getImage());
        parameterMap.put("stock_quantity",newProduct.getStock_quantity());
        parameterMap.put("category_id",newProduct.getCategory_id());
        parameterMap.put("product_id",newProduct.getProduct_id());
                
        updateGenericDAO(sql, parameterMap);
    }

    public static void main(String[] args) {
        Product newProduct = Product.builder()
                .product_id(61)
                .name("T-shirt8")
                .category_id(1)
                .stock_quantity(20)
                .price(28.8)
                .build();
        new ProductDAO().updateProductById(newProduct);
    }
}


