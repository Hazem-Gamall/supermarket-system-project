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
public abstract class Person {
    
    PersonSpec spec;

    public Person(PersonSpec spec){
        this.spec = spec;
    }
    
    public PersonSpec getSpec(){
        return spec;
    }
}
