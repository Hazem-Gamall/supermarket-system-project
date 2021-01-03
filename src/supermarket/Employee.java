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
public abstract class Employee implements Person {
    private String name;
    private int age;
    private int id;
    protected double salary;
    
    public Employee(String name, int age, int id, double salary){
        this.name = name;
        this.age = age;
        this.id = id;
        this.salary = salary;
    }
    
    @Override
    public void setName(String name){
        this.name = name;
    }
    @Override
    public String getName(){
        return name;
    }
    @Override
    public void setAge(int age) throws Exception{
        if(age < 18 && age > 60){
            throw new Exception("the age you entered Invalid");
        }else{
            this.age = age;
        }
    }
    @Override
    public int getAge(){
        return age;
    }
    @Override
    public void setId(int id){
        this.id = id;
    }
    @Override
    public int getId(){
        return id;
    }
    
    public abstract void setSalary(double salary);
    public abstract double getSalary();
}
