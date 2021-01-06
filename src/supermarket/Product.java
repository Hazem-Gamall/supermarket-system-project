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
public class Product extends ProjectUtil{
    private int id;
    private String name;
    private double price;
    private int quantity;
    private String producer;

    public Product(int id, String name, String producer, double price, int quantity){
      setId(id);
      setName(name);
      setProducer(producer);
      setPrice(price);
      setQuantity(quantity);
    }

    public void setId(int iden) {
      id = iden;
    }

    public int getId() {
      return id;
    }

    public void setName(String nm) {
      name = nm;
    }

    public String getName() {
      return name;
    }
      public void setPrice(double prc) {
      price = prc;
    }
    public double getPrice() {
      return price;
    }
     public void setQuantity(int q) {
      quantity = q;
    }

    public int getQuantity() {
      return quantity;
    }

      public String getProducer() {
          return producer;
      }

      public void setProducer(String producer) {
          this.producer = producer;
      }


    @Override
    public void update(Connection con) throws SQLException{
        Statement s = con.createStatement();
        String query = String.format("insert into product values(%d,'%s', '%s',%d, %f)", id,name,producer,quantity,price);
        s.executeUpdate(query);
    }

    @Override
    public String toString() {
      return String.format(" Product [id=%d, name=%s, price=%.2f, available quantity=%d] ",
          getId(),getName(), getPrice(), getQuantity());
    }
}
