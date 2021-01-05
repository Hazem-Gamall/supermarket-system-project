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
public abstract class Employee extends ProjectUtil implements Person {
    private String name;
    private int age;
    private int id;
    private String phone_num;
    protected double salary;
    
    
    public Employee(int id, String name, int age, String phone_num){
        this.id = id;
        this.name = name;
        this.age = age;
        this.phone_num = phone_num;
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
    @Override
    public void setPhoneNum(String phone_num){
        this.phone_num = phone_num;
    }
    @Override
    public String getPhoneNum(){
        return phone_num;
    }
    
    public double getSalary(){
        return salary;
    }
    
    public abstract void setSalary();

    
}
