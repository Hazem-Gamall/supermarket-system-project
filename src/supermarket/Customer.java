/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author hazem
 */
public class Customer extends ProjectUtil{
    private int id;
    private String name;
    private String gender;
    private String phone_num;
    
    
    public Customer(int id, String name, String gender, String phone_num){
        this.name = name;
        this.gender = gender;
        this.id = id;
        this.phone_num = phone_num;
    }
    
    
    public void setName(String name){
        this.name = name;
    }
  
    public String getName(){
        return name;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public int getId(){
        return id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }
    
    
    
    @Override
    public void update(Connection con) throws SQLException{
        Statement s = con.createStatement();
        String query = String.format("insert into customer values(%d,'%s', '%s','%s')", id,name,gender,phone_num);
        s.executeUpdate(query);
    }
    
}
