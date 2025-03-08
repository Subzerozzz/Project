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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
    
            
    
    public static void main(String[] args) {
        for(Product a : new ProductDAO().getDataByCategoryIdForPagination("15" , "1")){
            System.out.println(a.toString());
        }
    }

//    public int getTotalRecordById(String id) {
//        String sql = "SELECT Count(*)\n" +
//                    "FROM dbo.Product as P \n" +
//                    "Where P.category_id=?";
//        parameterMap = new LinkedHashMap<>();
//        parameterMap.put("P.category_id", id);
//        
//        return findTotalRecordGenericDAO(Product.class, sql, parameterMap);
//    }


}
