package stream;

import dummy.User;
import java.util.Comparator;
import java.util.List;
import org.junit.Test;

public class SortTest {

  @Test
  public void ageSortTest(){
    List<User> users = User.getUsers();

    users.stream()
      .sorted(Comparator.comparing(User::getAge))
      .forEach(System.out::println);

    System.out.println("---------");

    users.stream()
      .sorted(Comparator.comparing(User::getAge).reversed())
      .forEach(System.out::println);
  }

  @Test
  public void nameSortTest(){
    List<User> users = User.getUsers();

    users.stream()
      .sorted(Comparator.comparing(User::getName))
      .forEach(System.out::println);

    System.out.println("---------");

    users.stream()
      .sorted(Comparator.comparing(User::getName).reversed())
      .forEach(System.out::println);
  }

  @Test
  public void nameAgeSortTest(){
    List<User> users = User.getUsers();

    users.stream()
      .sorted(Comparator.comparing(User::getName)
        .thenComparing(User::getAge).reversed())
      .forEach(System.out::println);
  }

}
