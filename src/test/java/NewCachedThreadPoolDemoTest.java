import com.dig.demo.pool_demo.MyThreadFactory;
import com.dig.demo.pool_demo.NewnewCachedThreadPoolDemo;

/**
 * @author 作者 E-mail:
 * @version 创建时间：${date} ${time}
 * 类说明
 */
public class NewCachedThreadPoolDemoTest {

    static int i = 0;

    public static void test1() {
        NewnewCachedThreadPoolDemo inst = NewnewCachedThreadPoolDemo.getThreadPoolInstWithThreadFactory(new MyThreadFactory());

        while (true) {
            for(int j=0;j<2;j++){
                inst.execute(new Runnable() {
                    public void run() {
                        System.out.println("我是任务" + i++);
                    }
                });
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(90000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }


    public static void main(String[] args) {

        test1();

    }

}
