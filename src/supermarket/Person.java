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
public interface Person {
    void setName(String name);
    String getName();
    void setAge(int age) throws Exception;
    int getAge();
    void setId(int id);
    int getId();
}
