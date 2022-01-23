package functionalinterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import org.junit.Test;

// Function : 1개의 인자 T를 받고 1개의 객체 R을 리턴하는 함수형 인터페이스
public class FunctionTest {

  private <T, R> List<R> map(
    List<T> list,
    Function<T, R> func
  ) {
    List<R> result = new ArrayList<>();
    for (T t : list) {
      result.add(func.apply(t));
    }
    return result;
  }
  
  @Test
  public void applyTest() {
    Function<Integer, Integer> func = number -> number * 10;
    System.out.println(func.apply(10));
  }

  @Test
  public void andThenTest() {
    //1. apply 인자는 먼저 func1에 전달된다.
    //2. func1의 결과가 func2의 인자로 전달된다.
    //3. func2 결과가 리턴된다.
    Function<Integer, Integer> func1 = n -> n * n;
    Function<Integer, String> func2 = n -> "result: " + n;

    System.out.println(func1.andThen(func2).apply(10));
  }

  @Test
  public void composeTest() {
    //1. addAndMultiply.apply(1)은 1이 add 함수 인자로 전달된다.
    //2. add 함수로 전달된 인자의 결과값이 multiply 함수의 인자로 전달된다.
    //3. multiply 결과값이 리턴된다.
    Function<Integer, Double> add = n -> n + 2.0;
    Function<Double, Double> multiply = n -> n * 5.0;
    Function<Integer, Double> addAndMultiply = multiply.compose(add);

    System.out.println(addAndMultiply.apply(1));
  }

  @Test
  public void doubleArgumentTest() {
    //1. weight mass 인자값으로 20.0 전달된다.
    //2. weight gravity 인자값으로 2.0이 전달된다.
    Function<Double, Function<Double, Double>> weight = mass -> gravity -> mass * gravity;
    Function<Double, Double> weightOnEarth = weight.apply(20.0);

    System.out.println(weightOnEarth.apply(2.0));
  }

  @Test
  public void mapTest() {
    List<String> list = Arrays.asList("banana", "dahee", "heehee");
    map(list, String::length).forEach(System.out::println);
    map(list, x -> x.length() > 5).forEach(System.out::println);
    map(list, x -> x.length() > 5 && x.startsWith("b")).forEach(System.out::println);
  }

}
