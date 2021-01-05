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
public class HourlyEmployee extends Employee {
    private double hour_rate;
    private double hours;

    
    public HourlyEmployee(int id, String name, int age,  String phone_num, double hour_rate, double hours){
        super(id, name, age, phone_num);
        this.hour_rate = hour_rate;
        this.hours = hours;
        setSalary();
    }
    
    @Override
    public void setSalary(){
        salary = hour_rate * hours;
    }
    
    @Override
    public void update(Connection con) throws SQLException{
        Statement s = con.createStatement();
        String query = String.format("insert into hourly_employee values(%d,'%s', '%d','%s', %f, %f, %f)", getId(), getName(), getAge(), getPhoneNum(), hour_rate, hours ,salary);
        s.executeUpdate(query);
    }
    
}
