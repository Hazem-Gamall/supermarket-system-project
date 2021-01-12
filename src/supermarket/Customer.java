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
public class Customer extends ProjectUtil implements Person{
    private int id;
    private int age;
    private String name;
    private String gender;
    private String phone_num;
    
    
    public Customer(int id, String name, int age, String gender, String phone_num) throws Exception{
        this.name = name;
        this.id = id;
        setAge(age);
        this.gender = gender;
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
    public int getAge() {
        return age;
    }

    @Override
    public void setAge(int age) throws Exception{
        if(age < 18 || age > 60){
            throw new Exception("the age you entered is Invalid, Make sure age is between 18 and 60");
        }else{
            this.age = age;
        }
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
    public void setPhoneNum(String phone_num) {
        this.phone_num = phone_num;
    }
    
    @Override
    public String getPhoneNum() {
        return phone_num;
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
        String query = String.format("insert into customer values(%d, '%s', %d, '%s', '%s')", id,name,age,gender,phone_num);
        s.executeUpdate(query);
    }
    
}
