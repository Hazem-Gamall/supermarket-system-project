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
    
    public SalariedEmployee(PersonSpec spec, double salary, double deduction, double bonus) throws Exception{
        super(spec, salary);
        this.deduction = deduction;
        this.bonus = bonus;
    }
    
    public double getDeduction() {
        return deduction;
    }

    public void setDeduction(double deduction) {
        this.deduction = deduction;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
    
    @Override
    public double getSalary(){
        return (super.getSalary() + bonus - deduction);
    }

    
    
    @Override
    public void update(Connection con) throws SQLException{
        Statement s = con.createStatement();
        //Bad design
        String query = String.format("insert into salaried_employee values(%d, '%s', '%d', '%s', %f, %f, %f, %f)", spec.getId(), spec.getName(), spec.getAge(), spec.getPhoneNum(), deduction, bonus , super.getSalary(), getSalary());
        s.executeUpdate(query);
    }
}
