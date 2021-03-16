/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket;

/**
 *
 * @author hazem
 */
public abstract class Employee extends Person implements Updatable {
    private double salary;
    
    
    public Employee(PersonSpec spec, double salary){
        super(spec);
        this.salary = salary;
    }
    
    public void setSalary(double salary){
        this.salary = salary;
    }
    
    public double getSalary(){
        return salary;
    }

}
