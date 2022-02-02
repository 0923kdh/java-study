package generics;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ParameterizedTypeTest {

  public class Fruit {
    private Object obj;

    public Fruit(Object obj){
      this.obj = obj;
    }

    public Object get(){
      return this.obj;
    }
  }

  public class GFruit<T> {
    private T t;

    public GFruit(T t){
      this.t = t;
    }

    public T get(){
      return this.t;
    }
  }

  @Test
  @DisplayName("비구체화 타입")
  public void nonReifiableTypeTest(){
    // 타입 소거자에 의해 컴파일 타임에 타입 정보가 사라짐.
    // 런타임에 구체화 하지않음.
    List<String> list = new ArrayList<>();
    list.add("Hi");

    assertThat(list.getClass().getSimpleName()).isEqualTo("ArrayList");
  }

  @Test
  @DisplayName("구체화 타입")
  public void reifiableTypeTest(){
    // 타입 정보를 런타임에 구체화함.
    Object[] array = new Long[10];
    array[0] = 1L;

    assertThat(array.getClass().getSimpleName()).isEqualTo("Long[]");
  }

  @Test
  @DisplayName("비제네릭 타입은 캐스팅을 해야한다.")
  public void nonGenericTypeCastingTest(){
    Fruit fruit = new Fruit("apple");
    String fruitName = (String) fruit.get();

    assertThat(fruitName).isEqualTo("apple");
  }

  @Test
  @DisplayName("제네릭 타입은 캐스팅을 하지않는다.")
  public void genericTypeCastingTest(){
    GFruit<String> fruit = new GFruit("apple");
    String fruitName = fruit.get();

    assertThat(fruitName).isEqualTo("apple");
  }

}
