package dummy;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Fruits {

  private String name;
  private int price;
  private int stock;

  public Fruits(
    String name,
    int price,
    int stock
  ) {
    this.name = name;
    this.price = price;
    this.stock = stock;
  }

  public static List<Fruits> getFruits(){
    return Arrays.asList(
      new Fruits("apple", 10, 1),
      new Fruits("applemango", 15, 10),
      new Fruits("mango", 15, 10),
      new Fruits("banana", 6, 1),
      new Fruits("watermelon", 3, 1)
    );
  }

  public String getName(){
    return this.name;
  }

  public int getPrice(){
    return this.price;
  }

  public int getStock(){
    return this.stock;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Fruits fruits = (Fruits) o;
    return price == fruits.price && stock == fruits.stock && Objects.equals(
      name, fruits.name
    );
  }

  @Override
  public String toString() {
    return "Fruits{" +
      "name='" + name + '\'' +
      ", price=" + price +
      ", stock=" + stock +
      '}';
  }
}