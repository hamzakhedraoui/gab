package server;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseConnection {
    Statement statement=null;
    public  DatabaseConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

        }catch(ClassNotFoundException e) {
            e.printStackTrace();
        }//projet_daw
        Connection cnx=null;
        try {
            cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/gab","root","");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        try {
            statement=cnx.createStatement();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public ArrayList<Account> getAccounts() {
        ArrayList<Account> accountArrayList = new ArrayList<>();
        String rq = "select * from account;";
        ResultSet r;
        try {
            r = statement.executeQuery(rq);
            while(r.next()) {
                Account account = new Account(r.getInt("id"),r.getString("firstname"),r.getString("lastname"),r.getDouble("debit"),r.getInt("lockes"),r.getString("cardNumber"));
                accountArrayList.add(account);
            }
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        for(Account acc : accountArrayList){
            System.out.println(acc);
        }
        return accountArrayList;

    }
}
