package generics;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// 재귀적 타입 바운드는 타입 매개변수가 자신을 포함하는 수식에 의해 한정될 수 있음
public class RecursiveTypeBound {

  interface Fruit {
  }

  class Apple implements Fruit, Comparable<Apple> {
    private final Integer size;

    public Apple(Integer size) {
      this.size = size;
    }

    @Override
    public int compareTo(Apple other) {
      return size.compareTo(other.size);
    }
  }

  class Orange implements Fruit, Comparable<Orange> {
    private final Integer size;

    public Orange(Integer size) {
      this.size = size;
    }

    @Override public int compareTo(Orange other) {
      return size.compareTo(other.size);
    }
  }

  @Test
  @DisplayName("타입 제한 테스트")
  public void typeConstraintTest(){
    Apple apple1 = new Apple(10);
    Apple apple2 = new Apple(10);

    assertThat(apple1.compareTo(apple2)).isEqualTo(0);
  }

  @Test
  @DisplayName("타입 오류 테스트")
  public void typeErrorTest(){
    Apple apple1 = new Apple(10);
    Orange orange1 = new Orange(10);

    //컴파일 오류
    //assertThat(apple1.compareTo(orange1)).isEqualTo(0);
  }

}
