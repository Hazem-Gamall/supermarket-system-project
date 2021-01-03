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
public class SuperMarket {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Product p = new Product("cheese",19.5,1);
        System.out.println(p.toString());
        
        Employee e = new Employee("omar",26,341,3456.5){
            @Override
            public double getSalary(){
                return salary;
            }
            @Override
            public void setSalary(double salary){
                this.salary = salary + 1000;
            }
        };
        
        e.setSalary(3500);
        System.out.println(e.getSalary());
    }
    
}
