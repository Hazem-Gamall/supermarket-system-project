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
public class PersonSpec {
    private String name, phone_num;
    private int age, id;
    private double a7a;
    
    public PersonSpec(String name, String phone_num, int age, int id, double a7a) throws Exception{
        this.name = name;
//        
        if(age < 18 || age > 65) throw new Exception("Wrong age!");
        else
            this.age = age;
        
        this.phone_num = phone_num;
        this.id = id;
    }
    
    public void setName(String name){this.name = name;}
    public String getName(){return name;}
    
    public void setAge(int age) throws Exception{
        if(age < 18 || age > 65) throw new Exception("Wrong age!");
        else
            this.age = age;
    }
    
    public int getAge(){return age;}
    public void setId(int id){this.id = id;}
    public int getId(){return id;}
    public void setPhoneNum(String phone_num){this.phone_num = phone_num;}
    public String getPhoneNum(){return phone_num;}
}
