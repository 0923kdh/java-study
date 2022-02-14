package generics;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WildcardSubtypingTest {

  private void addAll(List<Number> list){
  }

  public void addAllWildcardType(List<? extends Number> list) {
  }

  @Test
  @DisplayName("와일드카드 테스트")
  public void wildcardAndSubtypingTest(){
    List<Integer> list = new ArrayList<>();
    //compile error
    //addAll(list);

    addAllWildcardType(list);
  }

}
