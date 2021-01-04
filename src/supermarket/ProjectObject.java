/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author hazem
 */
public abstract class ProjectObject {
    public final static String URL = "jdbc:sqlite:supermarket.db";
    private static Connection con = null;
    public static Connection getcon() throws SQLException{
        if(con == null){
            con = DriverManager.getConnection(URL);
        }else{
           con.close();
           con = DriverManager.getConnection(URL);
        }
        return con;
    }
    
    public abstract void update(Connection con) throws SQLException;
     
    public static ResultSet fetch(Connection con, String table) throws SQLException{
        Statement s = con.createStatement();
        String query = String.format("SELECT * FROM %s", table);
        ResultSet r = s.executeQuery(query);
        return r;
    }
    public static void delete(Connection con, String table, int id) throws SQLException{
        Statement s = con.createStatement();
        String query = String.format("DELETE FROM %s WHERE %s_id ='%d'",table,table, id);
        int r = s.executeUpdate(query);
    }
}
