package functionalinterface;

import static dummy.Fruits.getFruits;

import dummy.Fruits;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class ComparatorTest {

  private List<Fruits> fruits = new ArrayList<>();

  @Before
  public void setUp(){
    fruits = getFruits();
  }

  @Test
  public void sortTest() {
    Collections.sort(fruits);

    fruits.forEach(System.out::println);
  }

  @Test
  public void reverseSortTest() {
    fruits.sort(Collections.reverseOrder());

    fruits.forEach(System.out::println);
  }

  @Test
  public void methodReferenceSortTest() {
    fruits.sort(
      Comparator.comparing(Fruits::getPrice)
        .thenComparing(Fruits::getStock)
        .thenComparing(Fruits::getName)
    );

    fruits.forEach(System.out::println);
  }

  @Test
  public void lambdaSortTest(){
    fruits.sort((s1, s2) -> Integer.compare(s1.getPrice(), s2.getPrice()));

    fruits.forEach(System.out::println);
  }

}
