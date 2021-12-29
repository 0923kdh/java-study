package stream;

import dummy.Fruits;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import org.junit.Test;

public class FilteringTest {

  List<Fruits> fruits = new ArrayList<>();

  @Test
  public void predicateTest(){
    fruits = Fruits.getFruits();
    Predicate<Fruits> isPriceOver = fruit -> fruit.getPrice() >= 10;

    fruits.stream()
      .filter(isPriceOver)
      .forEach(System.out::println);
  }

  @Test
  public void predicateAndTest() {
    fruits = Fruits.getFruits();
    Predicate<Fruits> isPriceOver = fruit -> fruit.getPrice() >= 10;
    Predicate<Fruits> isStockOver = fruit -> fruit.getStock() >= 10;

    fruits.stream()
      .filter(isPriceOver.and(isStockOver))
      .forEach(System.out::println);
  }

  @Test
  public void predicateOrTest(){
    fruits = Fruits.getFruits();
    Predicate<Fruits> matchNameStartsWith = fruit -> fruit.getName().startsWith("a");
    Predicate<Fruits> isStockOver = fruit -> fruit.getStock() >= 10;

    fruits.stream()
      .filter(matchNameStartsWith.or(isStockOver))
      .forEach(System.out::println);
  }

  @Test
  public void predicateNegateTest(){
    fruits = Fruits.getFruits();
    Predicate<Fruits> matchNameStartsWith = fruit -> fruit.getName().startsWith("a");
    Predicate<Fruits> isOver = fruit -> fruit.getStock() >= 10;

    fruits.stream()
      .filter(matchNameStartsWith.or(isOver).negate())
      .forEach(System.out::println);
  }

}
