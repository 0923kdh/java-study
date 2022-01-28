package stream;

import static dummy.Fruits.getFruits;

import dummy.Fruits;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.Before;
import org.junit.Test;

public class GroupingTest {

  private List<Fruits> fruits = new ArrayList<>();

  @Before
  public void setUp() {
    fruits = getFruits();
  }

  @Test
  public void groupingByTest() {
    Map<String, List<Fruits>> fruitsGroup = fruits.stream()
      .collect(Collectors.groupingBy(Fruits::getName));

    fruitsGroup.forEach((key, value) -> System.out.println("key : " + key + ", value : " + value));
  }

  @Test
  public void groupingByMultipleKeyTest() {
    Map<String, Map<Integer, List<Fruits>>> fruitsGroup = fruits.stream()
      .collect(
        Collectors.groupingBy(
          Fruits::getName,
          Collectors.groupingBy(Fruits::getStock)
        )
      );

    System.out.println(fruitsGroup);
  }

  @Test
  public void averagingTest() {
    Map<String, Double> fruitStockAverage = fruits.stream()
      .collect(Collectors.groupingBy(
          Fruits::getName,
          Collectors.averagingDouble(Fruits::getStock)
        )
      );

    System.out.println(fruitStockAverage);
  }

  @Test
  public void toSetTest() {
    Map<String, Set<Fruits>> fruitsGroup = fruits.stream()
      .collect(Collectors.groupingBy(Fruits::getName, Collectors.toSet()));

    System.out.println(fruitsGroup);
  }
  
}
