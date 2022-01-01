package stream;

import dummy.User;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class ReduceTest {

  @Test
  public void sumTest() {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    int result1 = numbers.stream()
      .reduce(
        0, (subtotal, element) -> subtotal + element
      );

    int result2 = numbers.stream()
      .reduce(
        0, Integer::sum
      );

    System.out.println(result1);
    System.out.println(result2);
  }

  @Test
  public void concatTest() {
    List<String> letters = Arrays.asList("d", "a", "h", "e", "e");
    String result1 = letters.stream()
      .reduce(
        "",
        (partialString, element) -> partialString + element
      );

    String result2 = letters.stream()
      .reduce(
        "",
        String::concat
      );

    System.out.println(result1);
    System.out.println(result2);
  }

  @Test
  public void upperCaseTest() {
    List<String> letters = Arrays.asList("d", "a", "h", "e", "e");

    //result1,2,3 결과를 보면 +가 어떤 방식으로 되는지 이해할 수 있음.
    String result1 = letters
      .stream()
      .reduce(
        "",
        (partialString, element) -> partialString.toUpperCase() + element.toUpperCase()
      );

    String result2 = letters
      .stream()
      .reduce(
        "kim",
        (partialString, element) -> partialString.toUpperCase() + element.toUpperCase()
      );

    String result3 = letters
      .stream()
      .reduce(
        "kim",
        (partialString, element) -> partialString + element.toUpperCase()
      );

    System.out.println(result1);
    System.out.println(result2);
    System.out.println(result3);
  }

  @Test
  public void userCombineTest() {
    List<User> users = Arrays.asList(
      new User(30, "dahee"), 
      new User(22, "damin")
    );

    String name = users.stream()
      .reduce(
        "",
        (partialNameResult, user) -> partialNameResult + user.getName(),
        String::concat
      );

    int age = users.stream()
      .reduce(
        0,
        (partialAgeResult, user) -> partialAgeResult + user.getAge(),
        Integer::sum
      );

    System.out.println(name);
    System.out.println(age);
  }

}
