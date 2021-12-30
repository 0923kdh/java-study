package dummy;

public class User {

  private int age;
  private String name;

  public User(int age, String name){
    this.age = age;
    this.name = name;
  }

  public boolean isOver() {
    return age >= 19;
  }


  @Override
  public String toString() {
    return "User{" +
      "age=" + age +
      ", name='" + name + '\'' +
      '}';
  }

}
