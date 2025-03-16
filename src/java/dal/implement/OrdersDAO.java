/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal.implement;

import dal.GenericDAO;
import entity.Cart;
import entity.Orders;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author User
 */
public class OrdersDAO extends GenericDAO<Orders> {

    @Override
    public List<Orders> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int insert(Orders t) {
        return insertGenericDAO2(t);
    }

    public List<Orders> getLatestId() {
        String sql = "SELECT TOP 1 * FROM Orders ORDER BY id DESC;";
        parameterMap = new LinkedHashMap<>();
        return queryGenericDAO(Orders.class, sql, parameterMap);
    }
    
    

    public List<Orders> getOrdersIdByCartID(int cartID) {
        String sql = "SELECT *\n" +
                "  FROM [dbo].[Orders]\n" +
                "  WHERE cartId = ?";
        parameterMap = new LinkedHashMap<>();
        parameterMap.put("cartId", cartID);
        
        return queryGenericDAO(Orders.class, sql, parameterMap);
    }
    
    public static void main(String[] args) {
        List<Orders> listOrder = new OrdersDAO().getOrdersIdByCartID(1);
         int orderID = listOrder.get(listOrder.size() - 1).getId();
         System.out.println(orderID);
    }
}
