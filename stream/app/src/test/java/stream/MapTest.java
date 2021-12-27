package stream;

import java.util.Arrays;
import org.junit.Test;

public class MapTest {

  @Test
  public void flatMapTest() {
    String[][] namesArray = new String[][]{
      {"kim", "da", "hee"}, {"lee", "ga", "tan"}};

    Arrays.stream(namesArray)
      .flatMap(Arrays::stream)
      .filter(name -> name.equals("kim"))
      .forEach(System.out::println);

    // map
    Arrays.stream(namesArray)
      .map(Arrays::stream)
      .forEach(names -> names.filter(name -> name.equals("ga"))
        .forEach(System.out::println));
  }

  @Test
  public void mapTest() {
    String[][] namesArray = new String[][]{
      {"kim", "da", "hee"}, {"lee", "ga", "tan"}};

    Arrays.stream(namesArray)
      .map(Arrays::stream)
      .forEach(names -> names.filter(name -> name.equals("ga"))
        .forEach(System.out::println));
  }

}