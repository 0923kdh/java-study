package thread;

import java.time.LocalTime;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

//특정 타입의 객체를 리턴
//Exception을 발생시킬 수 있음
public class CallableExample {

  static class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
      String result = "Called at " + LocalTime.now();
      return result;
    }
  }

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    MyCallable callable = new MyCallable();
    FutureTask futureTask = new FutureTask(callable);
    Thread thread = new Thread(futureTask);
    thread.start();

    //결과 리턴 기다림
    System.out.println("result : " + futureTask.get());
  }
}
