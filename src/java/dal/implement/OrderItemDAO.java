/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal.implement;

import dal.GenericDAO;
import entity.OrderItem;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author User
 */
public class OrderItemDAO extends GenericDAO<OrderItem> {

    @Override
    public List<OrderItem> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int insert(OrderItem t) {
        return insertGenericDAO2(t);
    }

    public List<OrderItem> getProductByOrderID(int orderID) {
        String sql = "select * from dbo.OrderItem\n" +
                    "where orderID = ?";
        parameterMap = new LinkedHashMap<>();
        parameterMap.put("orderID", orderID);
        
        return queryGenericDAO(OrderItem.class, sql, parameterMap);
    }
    
    public static void main(String[] args) {
        for(OrderItem o : new OrderItemDAO().getProductByOrderID(8)){
            System.out.println(o.toString());
        }
    }
}
