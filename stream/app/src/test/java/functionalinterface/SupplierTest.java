package functionalinterface;

import dummy.Fruits;
import java.util.List;
import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;
import java.util.function.LongSupplier;
import java.util.function.Supplier;
import org.junit.Test;

//Supplier : 인자를 받지 않고 Type T 객체를 리턴하는 함수형 인터페이스
public class SupplierTest {

  @Test
  public void supplierTest() {
    Supplier<String> supplier1 = () -> "Hello World";
    System.out.println(supplier1.get());

    Supplier<Fruits> supplier2 = () -> new Fruits("banana", 100, 10);
    System.out.println(supplier2.get().getName());
    System.out.println(supplier2.get().getPrice());
    System.out.println(supplier2.get().getStock());

    Supplier<List<Fruits>> supplier3 = Fruits::getFruits;
    supplier3.get().forEach(fruit -> {
      System.out.println(fruit.getName());
      System.out.println(fruit.getPrice());
      System.out.println(fruit.getStock());
    });
  }

  @Test
  public void primitiveSupplierTest(){
    String str = "dahee";

    BooleanSupplier booleanSupplier = () -> str.equals("daheehee");
    IntSupplier intSupplier = str::length;
    LongSupplier longSupplier = str::length;
    DoubleSupplier doubleSupplier = () -> 1000.10 - str.length();

    System.out.println(booleanSupplier.getAsBoolean());
    System.out.println(intSupplier.getAsInt());
    System.out.println(longSupplier.getAsLong());
    System.out.println(doubleSupplier.getAsDouble());
  }

}
