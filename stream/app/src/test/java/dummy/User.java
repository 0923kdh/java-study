package dummy;

import java.util.Arrays;
import java.util.List;

public class User {

  private int age;
  private String name;

  public User(
    int age,
    String name
  ) {
    this.age = age;
    this.name = name;
  }

  public static List<User> getUsers(){
    return Arrays.asList(
      new User(20, "dahee"),
      new User(20, "dam"),
      new User(40, "min"),
      new User(30, "minhee"),
      new User(10, "jung")
    );
  }

  public boolean isOver() {
    return this.age >= 19;
  }

  public int getAge() {
    return this.age;
  }

  public String getName() {
    return this.name;
  }

  @Override
  public String toString() {
    return "User{" +
      "age=" + age +
      ", name='" + name + '\'' +
      '}';
  }

}
