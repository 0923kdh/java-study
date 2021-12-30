package collection;

import dummy.User;
import java.util.Arrays;
import org.junit.Test;

public class MyCollectionTest {

  @Test
  public void collectionMethodTest() {
    new MyCollection<>(Arrays.asList("ABCD", "B", "CD"))
      .map(String::length)
      .filter(num -> num % 2 == 0)
      .foreach(System.out::println);
  }

  @Test
  public void ageValidateTest() {
    new MyCollection<User>(
      Arrays.asList(
        new User(15, "A"),
        new User(16, "B"),
        new User(17, "C"),
        new User(18, "D"),
        new User(19, "E"),
        new User(20, "F")
      )
    ).filter(User::isOver)
      .foreach(System.out::println);
  }

}
