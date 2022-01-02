package stream;

import dummy.Fruits;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
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

  @Test
  public void predicateReduceTest(){
    List<String> firstNames = Arrays.asList("dahee", "dam", "minjin", "heehee", "min");
    List<Predicate<String>> allPredicates = new ArrayList<Predicate<String>>();
    allPredicates.add(str -> str.startsWith("d"));
    allPredicates.add(str -> str.contains("h"));
    allPredicates.add(str -> str.length() > 4);

    List<String> result1 = firstNames.stream()
      .filter(allPredicates.stream().reduce(x->true, Predicate::and))
      .collect(Collectors.toList());

    List<String> result2 = firstNames.stream()
      .filter(allPredicates.stream().reduce(x->false, Predicate::or))
      .collect(Collectors.toList());

    result1.forEach(System.out::println);
    System.out.println("------");
    result2.forEach(System.out::println);
  }

}
