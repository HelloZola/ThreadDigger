import com.dig.demo.pool_demo.MyThreadFactory;
import com.dig.demo.pool_demo.NewSingleThreadPoolDemo;

/**
 * @author 作者 E-mail:
 * @version 创建时间：${date} ${time}
 * 类说明
 */
public class NewSingleThreadPoolDemoTest {

    static int i = 0;

    public static void test1() {
        NewSingleThreadPoolDemo inst = NewSingleThreadPoolDemo.getThreadPoolInstWithThreadFactory(new MyThreadFactory());

        while (true) {
            for(int j=0;j<5;j++){
                inst.execute(new Runnable() {
                    public void run() {
                        int cur_i = i++;
                        System.out.println("我是任务" + cur_i+" 正在执行我的线程名字叫做:"+Thread.currentThread().getName());
//                        try {
//                            //Thread.sleep(5000);
//                            System.out.println("任务"+cur_i+"休息完毕");
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
                    }
                });

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
