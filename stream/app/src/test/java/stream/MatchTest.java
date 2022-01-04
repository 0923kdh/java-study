package stream;

import dummy.Fruits;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import org.junit.Test;

public class MatchTest {

  @Test
  public void anyMatchTest() {
    List<Fruits> fruits = Fruits.getFruits();
    boolean isMatching = fruits.stream()
      .anyMatch(fruit -> fruit.getPrice() > 100);

    System.out.println(isMatching);
  }

  @Test
  public void allMatchTest(){
    List<Fruits> fruits = Fruits.getFruits();
    boolean isMatching = fruits.stream()
      .allMatch(fruit -> fruit.getPrice() > 1);

    System.out.println(isMatching);
  }

  @Test
  public void noneMatchTest(){
    List<Fruits> fruits = Fruits.getFruits();
    boolean isMatching = fruits.stream()
      .noneMatch(fruit -> fruit.getPrice() > 1);

    System.out.println(isMatching);
  }

  @Test
  public void listMatchTest(){
    List<Fruits> fruits = Fruits.getFruits();
    List<Fruits> newFruits = Arrays.asList(
      new Fruits("orange", 10, 1),
      new Fruits("apple", 10, 1),
      new Fruits("applemango", 15, 10),
      new Fruits("mango", 15, 10),
      new Fruits("banana", 6, 1)
    );

    fruits.stream()
      .filter(fruit -> newFruits.stream().anyMatch(Predicate.isEqual(fruit)))
      .collect(Collectors.toList())
      .forEach(System.out::println);
  }

}
