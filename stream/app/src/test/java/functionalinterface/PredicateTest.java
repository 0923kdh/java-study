package functionalinterface;

import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.Test;

// Predicate란?
// Type T 인자를 받고 boolean을 리턴하는 함수형 인터페이스.
public class PredicateTest {

  @Test
  public void testMethodTest(){
    Predicate<Integer> predicate = (num) -> num > 10;
    boolean result1 = predicate.test(100);
    boolean result2 = predicate.test(1);

    System.out.println(result1);
    System.out.println(result2);

    Stream<Integer> stream = IntStream.range(1, 14).boxed();

    stream.filter((num) -> num > 10)
      .forEach(System.out::println);
  }

  @Test
  public void andMethodTest(){
    Predicate<Integer> predicate1 = (num) -> num > 10;
    Predicate<Integer> predicate2 = (num) -> num < 20;
    boolean result1 = predicate1.and(predicate2).test(25);
    boolean result2 = predicate1.and(predicate2).test(15);

    System.out.println("25 : 10 < num < 20 ? " + result1);
    System.out.println("15: 10 < num < 20 ? " + result2);

    Stream<Integer> stream = IntStream.range(1, 30).boxed();

    stream.filter(predicate1.and(predicate2))
      .forEach(System.out::println);
  }

  @Test
  public void orMethodTest(){
    Predicate<Integer> predicate1 = (num) -> num > 10;
    Predicate<Integer> predicate2 = (num) -> num < 3;
    boolean result1 = predicate1.or(predicate2).test(1);
    boolean result2 = predicate1.or(predicate2).test(7);
    boolean result3 = predicate1.or(predicate2).test(25);

    System.out.println("1 : num < 3 or num > 10 ? " + result1);
    System.out.println("7 : num < 3 or num > 10 ? " + result2);
    System.out.println("25 : num < 3 or num > 10 ? " + result3);

    Stream<Integer> stream = IntStream.range(1, 15).boxed();

    stream.filter(predicate1.or(predicate2))
      .forEach(System.out::println);
  }

  @Test
  public void isEqualMethodTest(){
    Stream<Integer> stream = IntStream.range(1, 10).boxed();

    stream.filter(Predicate.isEqual(5))
      .forEach(System.out::println);
  }

  @Test
  public void negateMethodTest(){
    Predicate<Integer> predicate = (num) -> num > 10;
    boolean result1 = predicate.test(100);
    boolean result2 = predicate.negate().test(100);

    System.out.println("100 is greater than 10 ? " + result1);
    System.out.println("100 is less than 10 ? " + result2);

    Stream<Integer> stream = IntStream.range(1, 15).boxed();

    stream.filter(predicate.negate())
      .forEach(System.out::println);
  }
  
}
