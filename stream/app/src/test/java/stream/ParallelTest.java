package stream;

import static dummy.Fruits.getFruits;

import dummy.Fruits;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import org.junit.Test;

public class ParallelTest {

  @Test
  public void parallelStreamTimeTest(){
    long start = System.currentTimeMillis();
    long sum = LongStream.range(0, 1_000_000_000).parallel().sum();

    System.out.println(sum);

    long end = System.currentTimeMillis();

    System.out.println(end - start);
  }

  @Test
  public void singleStreamTimeTest(){
    long start = System.currentTimeMillis();

    long sum = LongStream.range(0, 1_000_000_000).sum();

    System.out.println(sum);

    long end = System.currentTimeMillis();

    System.out.println(end - start);
  }

  @Test
  public void parallelStreamListAddTest(){
    List<Integer> numbers = new ArrayList<>();
    for (int i = 0; i < 100000; i++) {
      numbers.add(i);
    }

    List<Integer> evenNumbers = new ArrayList<>();
    try{
      numbers.parallelStream().filter(number -> number % 2 == 0).forEach(evenNumbers::add);
    }catch (ArrayIndexOutOfBoundsException e){
      //병렬처리이기때문에 항상 ArrayIndexOutOfBoundsException가 발생하는것은 아님.
      System.out.println("ArrayIndexOutOfBoundsException");
    }

    System.out.println(evenNumbers.size());
  }

  @Test
  public void parallelStreamSynchronizedListAddTest(){
    List<Integer> numbers = new ArrayList<>();

    for (int i = 0; i < 100000; i++) {
      numbers.add(i);
    }

    List<Integer> evenNumbers = Collections.synchronizedList(new ArrayList<>());
    numbers.parallelStream().filter(number -> number % 2 == 0).forEach(evenNumbers::add);

    System.out.println(evenNumbers.size());
  }

  @Test
  public void parallelStreamCollectToListTest(){
    List<Integer> numbers = new ArrayList<>();
    for (int i = 0; i < 100000; i++) {
      numbers.add(i);
    }

    //collect 함수에는 병렬처리와 동시성을 확인하여 처리하는 부분이 포함되어 있음.
    List<Integer> evenNumbers = numbers.parallelStream()
      .filter(number -> number % 2 == 0)
      .collect(Collectors.toList());

    System.out.println(evenNumbers.size());
  }

  @Test
  public void parallelStreamTest() {
    List<Fruits> fruits = getFruits();

    Stream<Fruits> parallelStream = fruits.parallelStream();

    parallelStream.forEach(System.out::println);
  }

  @Test
  public void concatStreamTest(){
    Stream<String> stream1 = Stream.of("Hello", "My", "Name", "Is", "Heehee");
    Stream<String> stream2 = Stream.of("What", "Is", "Your", "Name?");

    Stream.concat(stream1, stream2).forEach(System.out::println);
  }

  @Test
  public void stringStreamTest() {
    Stream<String> stringStream = Pattern.compile(",").splitAsStream("a,b,c,d,e");
    stringStream.forEach(System.out::println);
  }
  
}
