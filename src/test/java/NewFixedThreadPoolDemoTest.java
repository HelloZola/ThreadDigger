import com.dig.demo.newFixedThreadPool.MyThreadFactory;
import com.dig.demo.newFixedThreadPool.NewFixedThreadPoolDemo;

public class NewFixedThreadPoolDemoTest {

    private static int count = 1;

    public static void test1() {

        NewFixedThreadPoolDemo demo = NewFixedThreadPoolDemo.getThreadPoolInst();
        cycle(demo);
    }

    public static void cycle(NewFixedThreadPoolDemo demo){
        for (int i = 0; i < 10; i++) {
            demo.execute(new Runnable() {
                public void run() {
                    try {
                        Thread.sleep(3000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println("获取到的count：" + count++);
                }
            });
        }
    }

    public static void test2() {
        NewFixedThreadPoolDemo demo = NewFixedThreadPoolDemo.getThreadPoolInstWithThreadFactory(new MyThreadFactory());
        cycle(demo);
    }

    public static void main(String[] args) {
        test2();
    }


}
