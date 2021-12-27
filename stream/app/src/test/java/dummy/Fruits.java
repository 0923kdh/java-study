package dummy;

import java.util.Arrays;
import java.util.List;

public class Fruits {

  private String name;
  private Integer price;
  private Integer stock;

  public Fruits(
    String name,
    Integer price,
    Integer stock
  ) {
    this.name = name;
    this.price = price;
    this.stock = stock;
  }

  public static List<Fruits> getFruits(){
    return Arrays.asList(new Fruits("apple", 1, 1),
      new Fruits("mango", 1, 1),
      new Fruits("banana", 1, 1),
      new Fruits("watermelon", 1, 1));
  }

  public String getName(){
    return this.name;
  }

  public Integer getPrice(){
    return this.price;
  }

  public Integer getStock(){
    return this.stock;
  }
}