package generics;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// 바운드 타입은 특정 타입으로 제한한다는 의미이다.
// 특정 타입의 서브타입으로만 제한을 시키겠다는 것으로 해석하면 된다.
public class BoundedTypeTest {

  public class Fruit<T extends Number> {
    private T t;

    public void set(T t) {
      this.t = t;
    }
  }

  class A {}
  interface B {}
  interface C {}

  //Multiple Bounds 도 된다.
  class D <T extends A & B & C> {}

  @Test
  @DisplayName("타입 제한 테스트")
  public void boundedTypeTest(){
    Fruit<Integer> fruit = new Fruit<>();
    fruit.set(1);

    // compile error
    //fruit.set("apple");
  }

}
