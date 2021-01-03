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
public class Product implements ProjectObject{
  private static int counter = 0;
  private int id;
  private String name;
  private double price;
  private int quantity;

  public Product(String nm, double prc, int q){
    counter++;
    setId(counter);
    setName(nm);
    setPrice(prc);
    setQuantity(q);
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

  public void update(Connection con) throws SQLException{
      Statement s = con.createStatement();
      String query = String.format("insert into Employees values(%d,'%s',%d)", 34,name,quantity);
      s.executeUpdate(query);
  }
  
  @Override
  public String toString() {
    return String.format(" Product [id=%d, name=%s, price=%.2f, available quantity=%d] ",
        getId(),getName(), getPrice(), getQuantity());
  }
}
