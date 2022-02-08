package generics;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SubtypingTest {

  public class Animal<T> {
    private T t;

    public void set(final T t) {
      this.t = t;
    }
  }

  public class Pet {}

  public class Dog extends Pet {}

  public void addAnimal(Animal<Pet> petList){
  }

  @Test
  @DisplayName("subtype test")
  public void subtypeTest(){
    Object obj = new Object();
    String str = "string type";
    obj = str;   // OK

    assertThat(obj.getClass().getSimpleName()).isEqualTo("String");
  }

  @Test
  @DisplayName("method list subtype test")
  public void listSubtypeTest(){
    Animal<Pet> petBox = new Animal<>();
    petBox.set(new Dog()); //ok
    petBox.set(new Pet()); //ok

    Animal<Dog> dogBox = new Animal<>();
    //compile error
    //addAnimal(dogBox);
  }

}
