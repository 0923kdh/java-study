package stream;

import java.util.Arrays;

public class FlatMap {

  public static void main(String[] args) {
    flatMapTest();
  }

  public static void flatMapTest(){
    String[][] namesArray = new String[][]{
      {"kim", "da", "hee"}, {"lee", "ga", "tan"}};

    // flatMap
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

}
