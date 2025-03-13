/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal.implement;

import dal.GenericDAO;
import entity.Cart;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author User
 */
public class CartDAO extends GenericDAO<Cart> {

    @Override
    public List<Cart> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int insert(Cart t) {
        return insertGenericDAO2(t);
    }

    public List<Cart> getIdByAccountID(int id) {
        String sql = "select * from dbo.Cart\n" +
                        "where accountId = ?";
        parameterMap = new LinkedHashMap<>();
        parameterMap.put("accountId", id);
        
        return queryGenericDAO(Cart.class, sql, parameterMap);
    }
    


    public int addNewCart(Cart newCart) {
        return insertGenericDAO2(newCart);
    }
    
    public List<Cart> getLatestId() {
        String sql = "SELECT TOP 1 * FROM cart ORDER BY id DESC;";
        parameterMap = new LinkedHashMap<>();
        return queryGenericDAO(Cart.class, sql, parameterMap);
    }


    
    public static void main(String[] args) {
        List<Cart> list = new CartDAO().getLatestId();
        System.out.println(list.get(0).getId());
    }
}
