import com.dig.demo.newFixedThreadPool.NewFixedThreadPoolDemo;
import jdk.jfr.events.ExceptionThrownEvent;
import org.junit.Test;

public class NewFixedThreadPoolDemoTest {

    private static int count = 1;

    public static void test1() {

        NewFixedThreadPoolDemo demo  = NewFixedThreadPoolDemo.getThreadPoolInst();
        for (int i = 0; i < 10; i++) {
            demo.execute(new Runnable() {
                public void run() {
                    try {
                        Thread.sleep(3000);
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                    System.out.println("获取到的count："+count++);
                }
            });
        }

    }

    public static void main(String[] args) {
        test1();
    }


}
