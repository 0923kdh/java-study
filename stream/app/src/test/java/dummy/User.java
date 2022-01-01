package dummy;

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
