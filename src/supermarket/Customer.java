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
public class Customer extends Person implements Updatable{
    private PersonSpec spec;
    private String gender;
    
    
    
    public Customer(PersonSpec spec, String gender) throws Exception{
        super(spec);
        this.gender = gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
        
    public String getGender() {
        return gender;
    }
    
    @Override
    public void update(Connection con) throws SQLException{
        Statement s = con.createStatement();
        String query = String.format("insert into customer values(%d, '%s', %d, '%s', '%s')", spec.getId(),spec.getName(),spec.getAge(),gender,spec.getPhoneNum());
        s.executeUpdate(query);
    }
    
}
