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
public interface ProjectObject {
     void update(Connection con) throws SQLException;
     
     static ResultSet fetch(Connection con, String table) throws SQLException{
        Statement s = con.createStatement();
        String query = String.format("select * from %s", table);
        ResultSet r = s.executeQuery(query);
        return r;
     }
     static void delete(Connection con, String table, int id) throws SQLException{
        Statement s = con.createStatement();
        String query = String.format("delete from %s where %s_id ='%d'",table,table, id);
        int r = s.executeUpdate(query);
     }
}
