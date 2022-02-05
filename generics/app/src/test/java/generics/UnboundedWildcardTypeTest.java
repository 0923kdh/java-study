package generics;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UnboundedWildcardTypeTest {

  // Only work for the list of object type.
  public void printListObject(List<Object> list) {
    for (Object element : list) {
      System.out.print(element + " ");
    }
  }

  // Reifiable
  // 컴파일시점에 Object로 치환
  // Work for the list of any type.
  public void printListWildCard(List<?> list) {
    for (Object element: list) {
      System.out.print(element + " ");
    }
  }

  // non-reifiable
  public void printExtendsObject(List<? extends Object> list) {
    for (Object element: list) {
      System.out.print(element + " ");
    }
  }

  @Test
  @DisplayName("Object, ?, ? extends Object 차이점 테스트")
  public void typeTest1(){
    List<String> stringTypeList = Arrays.asList("a", "b", "c");

    printListWildCard(stringTypeList);
    printExtendsObject(stringTypeList);
    // 컴파일 오류.
    //printListObject(stringTypeList);

    List<Object> objectTypeList = Arrays.asList("a", "b", "c");
    printListObject(objectTypeList);
  }

  @Test
  @DisplayName("?, ? extends Object 차이점 테스트")
  public void typeTest2() {
    List list1 = new ArrayList<>();
    assertThat(list1 instanceof List<?>).isEqualTo(true);

    List list2 = new ArrayList<>();
    assertThat(list2 instanceof List<? extends Object>).isEqualTo(true);

    // 컴파일 오류
    //List<?>[] arrayOfList = new List<?>[1];
    //List<? extends Object>[] arrayOfAnotherList = new List<? extends Object>[1]
  }

}
