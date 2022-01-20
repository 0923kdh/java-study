package functionalinterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import org.junit.Test;

// Consumer : 매개 값을 받아 소비만 하고 리턴 값을 가지지 않는다.
// 하나의 제네릭 매개변수를 받아 사용하는 Consumer<T>
// 두 개의 제네릭 매개변수를 받아 사용하는 BiConsumer<T, U>
// Number 타입 : IntConsumer, DoubleConsumer, LongConsumer
// Object와 Number 함께 사용 : ObjIntConsumer, ObjDoubleConsumer, ObjLongConsumer
public class ConsumerTest {

  private <T> void forEach(List<T> list, Consumer<T> consumer) {
    for (T t : list) {
      consumer.accept(t);
    }
  }

  private <T, U, R> List<R> listCombiner(
    List<T> list1, List<U> list2, BiFunction<T, U, R> combiner
  ) {
    List<R> result = new ArrayList<>();
    for (int i = 0; i < list1.size(); i++) {
      result.add(combiner.apply(list1.get(i), list2.get(i)));
    }
    return result;
  }

  private boolean firstIsGreaterThanSecond(Integer number1, Integer number2) {
    return number1 > number2;
  }

  @Test
  public void consumerTest() {
    Consumer<String> consumer = System.out::println;
    consumer.accept("kimdahee");
  }

  @Test
  public void biConsumerTest(){
    BiConsumer<String, Integer> bis = (name, age) -> {
      System.out.println("이름 : " + name + "나이 : " + age);
    };
    bis.accept("kimdahee", 11);
  }

  @Test
  public void intConsumerTest(){
    Consumer<String> consumer = System.out::println;
    consumer.accept("I'm Heehee");

    IntConsumer intConsumer = age -> {
      System.out.println(age + " years old.");
    };
    intConsumer.accept(10);
  }

  @Test
  public void foreachTest(){
    List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
    Consumer<Integer> consumer1 = System.out::println;
    forEach(list1, consumer1);
    forEach(list1, System.out::println);

    List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14);
    Consumer<Integer> consumer2 = number -> {
      if (number % 2 == 0) {
        System.out.println(number);
      }
    };
    forEach(list2, consumer2);
  }

  @Test
  public void listCombinerTest(){
    List<String> list1 = Arrays.asList("a", "b", "c");
    List<Integer> list2 = Arrays.asList(1, 2, 3);
    listCombiner(list1, list2, (a, b) -> a + b).forEach(System.out::println);

    List<Integer> list3 = Arrays.asList(1, 2, 3);
    List<Integer> list4 = Arrays.asList(1, 2, 3);
    listCombiner(list3, list4, (a, b) -> a * b).forEach(System.out::println);

    List<Integer> list5 = Arrays.asList(100, 2, 3, 0);
    List<Integer> list6 = Arrays.asList(1, 100, 100, 0);
    listCombiner(list5, list6, this::firstIsGreaterThanSecond).forEach(System.out::println);
  }

}
