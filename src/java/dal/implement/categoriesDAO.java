/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal.implement;

import dal.GenericDAO;
import entity.categories;
import java.util.List;

/**
 *
 * @author User
 */
public class categoriesDAO extends GenericDAO<categories> {

    @Override
    public List<categories> findAll() {
        return queryGenericDAO(categories.class);
    }

    @Override
    public int insert(categories t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public static void main(String[] args) {
        for(categories a : new categoriesDAO().findAll()){
            System.out.println(a.toString());
        }
    }
    
}
