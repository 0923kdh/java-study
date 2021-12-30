package stream;

import dummy.Fruits;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import org.junit.Test;

public class StreamTest {

  List<Fruits> fruits = new ArrayList<>();

  @Test
  public void forEachTest(){
    fruits = Fruits.getFruits();
    fruits.forEach(fruit -> {
      System.out.println(fruit.getName());
      System.out.println(fruit.getPrice());
      System.out.println(fruit.getStock());
    });
  }

  @Test
  public void listStreamTest(){
    fruits = Fruits.getFruits();
    String[] fruitsName = fruits.stream()
      .map(Fruits::getName)
      .toArray(String[]::new);
    Arrays.stream(fruitsName)
      .forEach(System.out::println);
  }

  @Test
  public void collectionStreamTest(){
    fruits = Fruits.getFruits();
    fruits.stream()
      .map(fruit -> {
        return fruit.getName()
          .toUpperCase();
      })
      .collect(Collectors.toList())
      .forEach(System.out::println);
  }

  @Test
  public void streamBuilderTest(){
    //스트림에 직접적으로 원하는 값을 넣을 수 있음.
    //마지막에 build 메소드로 스트림 리턴.
    Stream<Fruits> builderStream =
      Stream.<Fruits>builder()
        .add(new Fruits("melon", 1, 1))
        .add(new Fruits("orange", 2, 1))
        .build();

    builderStream.map(fruit -> {
        return new Fruits(fruit.getName(), fruit.getPrice(), fruit.getStock());
      })
      .collect(Collectors.toList()).forEach(fruit -> {
        System.out.println(fruit.getName());
        System.out.println(fruit.getPrice());
        System.out.println(fruit.getStock());
      });
  }

  @Test
  public void streamGenerateTest(){
    //인자는 없고 리턴값만 있는 함수형 인터페이스
    //람다에서 리턴하는 값이 생성.
    //스트림의 사이즈가 무한하기 때문에 특정 사이즈로 제한해야 함.
    Stream.generate(() -> "hi").limit(5).toList().forEach(System.out::println);
  }

  @Test
  public void streamIterateTest(){
    //초기값과 해당 값을 다루는 람다를 이용해서 스트림에 들어갈 요소를 만듦
    //10이 초기값이고 값이 5씩 증가하는 값들이 들어감
    //요소가 다음 요소의 인풋으로 들어가는 것을 의미
    //스트림의 사이즈가 무한하기 때문에 특정 사이즈로 제한해야 함.
    Stream.iterate(10, n -> n + 5).limit(5).toList().forEach(System.out::println);
  }

  @Test
  public void defaultTypeStreamTest(){
    //제네릭을 사용하지 않고 직접적으로 해당 타입의 스트림을 다룰 수 있음
    //range 와 rangeClosed 는 범위의 차이.
    //두 번째 인자인 종료지점이 포함되느냐 안되느냐의 차이입니다.
    IntStream intStream = IntStream.range(1, 5); // [1, 2, 3, 4]
    LongStream longStream = LongStream.rangeClosed(1, 5); // [1, 2, 3, 4, 5]

    //제네릭을 사용하지 않기 때문에 불필요한 오토박싱(auto-boxing)이 일어나지 않음.
    //필요한 경우 boxed 메소드를 이용해서 박싱(boxing)할 수 있음.
    Stream<Integer> boxedIntStream = IntStream.range(1, 5).boxed();
    List<Integer> boxedIntList = IntStream.range(1, 5).boxed().toList();
  }

  @Test
  public void stringStreamTest(){
    //스트링을 이용해서 스트림을 생성 가능
    //각 문자(char)를 IntStream 으로 변환한 예제.
    "Stream".chars().boxed().toList().forEach(System.out::println); // [83, 116, 114, 101, 97, 109]
  }

  @Test
  public void regexStreamTest(){
    Pattern.compile(", ").splitAsStream("dahee, heehee, hee").toList().forEach(System.out::println);
  }

}
