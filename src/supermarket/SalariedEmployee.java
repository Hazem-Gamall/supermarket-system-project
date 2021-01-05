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
public class SalariedEmployee extends Employee{
    private double deduction;
    private double bonus;
    private double base_salary;
    
    public SalariedEmployee(int id, String name, int age,  String phone_num, double deduction, double bonus, double base_salary){
        super(id, name, age, phone_num);
        this.deduction = deduction;
        this.bonus = bonus;
        this.base_salary = base_salary;
    }
    
    @Override
    public void setSalary(){
        salary = base_salary - deduction + bonus;
    }
    
    @Override
    public void update(Connection con) throws SQLException{
        Statement s = con.createStatement();
        String query = String.format("insert into salaried_employee values(%d, '%s', '%d', '%s', %f, %f, %f)", getId(), getName(), getAge(), getPhoneNum(), deduction, bonus ,salary);
        s.executeUpdate(query);
    }
}
