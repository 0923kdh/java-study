package thread;

//어떤 객체도 리턴하지 않음
//Exception을 발생시킬 수 없음
public class RunnableExample implements Runnable {

  @Override
  public void run() {
    System.out.println(Thread.currentThread().getName() + " : thread has ended");
  }

  public static void main(String[] args) {
    RunnableExample ex = new RunnableExample();

    int loopCnt = 100;
    for(int i = 0; i < 100; i++){
      Thread thread= new Thread(ex, "RunnableThread " + i);
      thread.start();
      System.out.println("Hi");
    }
  }

}
