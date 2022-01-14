package stream;

import static dummy.Fruits.getFruits;

import dummy.Fruits;
import java.util.Comparator;
import java.util.List;
import org.junit.Test;

public class CalculateTest {

  @Test
  public void findMinMaxPriceTest() {
    List<Fruits> fruits = getFruits();
    System.out.println(
      fruits.stream().map(Fruits::getPrice).max(Comparator.comparing(x -> x)).orElse(0)
    );

    System.out.println(
      fruits.stream().map(Fruits::getPrice).min(Comparator.comparing(x -> x)).orElse(0)
    );
  }

  @Test
  public void findLongestName(){
    List<Fruits> fruits = getFruits();
    System.out.println(
      fruits.stream().map(Fruits::getName).mapToInt(String::length).max().orElse(0)
    );
  }

  @Test
  public void findAveragePriceTest() {
    List<Fruits> fruits = getFruits();
    System.out.println(
      fruits.stream().mapToInt(Fruits::getPrice).average().orElse(Double.NaN)
    );
  }

  @Test
  public void findSumPriceTest(){
    List<Fruits> fruits = getFruits();
    System.out.println(
      fruits.stream().mapToInt(Fruits::getPrice).sum()
    );
  }

}
