/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal.implement;

import dal.GenericDAO;
import entity.Account;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author User
 */
public class AccountDAO extends GenericDAO<Account> {

    @Override
    public List<Account> findAll() {
        return queryGenericDAO(Account.class);
    }

    @Override
    public int insert(Account t) {
        String sql = "INSERT INTO [dbo].[Account]\n" +
                        "           ([username]\n" +
                        "           ,[password]\n" +
                        "           ,[email]\n" +
                        "           ,[address]\n" +
                        "           ,[roleid])\n" +
                        "     VALUES\n" +
                        "           (?\n" +
                        "           ,?\n" +
                        "           ,?\n" +
                        "           ,?\n" +
                        "           ,2)";
        parameterMap = new LinkedHashMap<>();
        parameterMap.put("username", t.getUsername());
        parameterMap.put("password", t.getPassword());
        parameterMap.put("email", t.getEmail());
        parameterMap.put("address", t.getAddress());
        
        return insertGenericDAO(sql, parameterMap);
    }
    
    public Account findByUserNameAndPass(Account account){
        String sql = "SELECT *\n" +
                    "FROM [dbo].[Account]\n" +
                    "WHERE username = ? and password = ?";
        parameterMap = new LinkedHashMap<>();
        parameterMap.put("username", account.getUsername());
        parameterMap.put("password", account.getPassword());
        
        List<Account> list = queryGenericDAO(Account.class, sql, parameterMap);
        return list.isEmpty()? null : list.get(0);
    }
    
    public static void main(String[] args) {
        Account account = Account.builder()
                .username("user1")
                .password("123")
                .build();
        System.out.println(new AccountDAO().findByUserNameAndPass(account));
    }

    public Account findByUserName(Account account) {
        String sql = "SELECT *\n" +
                    "FROM [dbo].[Account]\n" +
                    "WHERE username = ?";
        parameterMap = new LinkedHashMap<>();
        parameterMap.put("username", account.getUsername());
        
        List<Account> list = queryGenericDAO(Account.class, sql, parameterMap);
        return list.isEmpty()? null : list.get(0);
    }

    
}
