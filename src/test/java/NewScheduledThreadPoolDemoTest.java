import com.dig.demo.pool_demo.MyThreadFactory;
import com.dig.demo.pool_demo.NewScheduledThreadPoolDemo;
import com.dig.utils.TimeUtil;


/**
 * @author 作者 E-mail:
 * @version 创建时间：${date} ${time}
 * 类说明
 */
public class NewScheduledThreadPoolDemoTest {

    static int i = 0;

    public static void test1() {
        NewScheduledThreadPoolDemo inst = NewScheduledThreadPoolDemo.getThreadPoolInstWithThreadFactory(new MyThreadFactory());

        while (true) {
            for (int j = 0; j < 5; j++) {
                inst.execute(new mytask(""+(i++)), 6, 10);
            }
            try {
                Thread.sleep(90000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class mytask implements Runnable {

        private String name;

        public mytask(String name_) {
            this.name = name_;
        }

        public void run() {
            System.out.println("正在运行...我是任务："+name+" 正在运行我的线程是："+Thread.currentThread().getName()+"  time:"+ TimeUtil.getDefaultNowTime());
//            try {
//                Thread.sleep(10000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println("休息完毕...我是任务："+name +" time:"+TimeUtil.getDefaultNowTime());
        }
    }


    public static void main(String[] args) {

        test1();

    }

}
