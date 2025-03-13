/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal.implement;

import dal.GenericDAO;
import entity.CartItem;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author User
 */
public class CartItemDAO extends GenericDAO<CartItem> {

    @Override
    public List<CartItem> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int insert(CartItem t) {
        return insertGenericDAO2(t);
    }

    public List<CartItem> getListCartItemById(int cartID) {
       String sql = "select * from dbo.CartItem\n" +
                    "where cartID = ?";
       parameterMap = new LinkedHashMap<>();
       parameterMap.put("cartID", cartID);
       
       return queryGenericDAO(CartItem.class, sql, parameterMap);
    }
    
    

    public int addNewCartItem(CartItem newCartItem) {
        return insertGenericDAO2(newCartItem);
    }
    
    public static void main(String[] args) {
        CartItem newCartItem = CartItem.builder()
                .cartID(7)
                .productID(27)
                .quantity(1)
                .build();
                
        new CartItemDAO().insert(newCartItem);
    }
    
}
