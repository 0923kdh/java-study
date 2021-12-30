package collection;

import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    new MyCollection<>(Arrays.asList("ABCD", "B", "CD"))
      .map(String::length)
      .filter(num -> num % 2 == 0)
      .foreach(System.out::println);
  }
}
