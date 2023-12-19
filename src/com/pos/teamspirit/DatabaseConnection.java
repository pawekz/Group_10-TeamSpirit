package com.pos.teamspirit;

import java.sql.*;

public class DatabaseConnection {
    private static final String url = "jdbc:mysql://localhost:3306/teamspiritpos";
    private static final String user = "admin";
    private static final String password = "password";

    public static Connection getConnection(){
        Connection con = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
        } catch (Exception e){
            System.out.println(e);
        }
        return con;
    }

}