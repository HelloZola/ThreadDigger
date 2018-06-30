import com.dig.demo.newFixedThreadPool.MyThreadFactory;
import com.dig.demo.pool_demo.NewWorkStealingPoolDemo;
import com.dig.utils.TimeUtil;

import java.util.Random;

/**
 * @author 作者 E-mail:
 * @version 创建时间：${date} ${time}
 * 类说明
 */
public class NewWorkStealingPoolDemoTest {

    static int i = 0;

    public static void runtask(NewWorkStealingPoolDemo inst){
        for(int j=0;j<20;j++){
            inst.execute(new Runnable() {
                public void run() {
                    int cur_i = i++;
                    System.out.println("我是任务" + cur_i+" 正在执行我的线程名字叫做:"+Thread.currentThread().getName()+" time:"+ TimeUtil.getDefaultNowTime());
                    try {
                        Random random = new Random();
                        int sleep_time = random.nextInt(19)+1;
                        Thread.sleep(sleep_time);
                        System.out.println("任务"+cur_i+"休息完毕,休息了"+sleep_time+"s"+" time:"+ TimeUtil.getDefaultNowTime());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        System.out.println("分配完毕！！！");
        while(true){
            try {
                Thread.sleep(8000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void test1() {
        NewWorkStealingPoolDemo inst = NewWorkStealingPoolDemo.getThreadPoolInstWithThreadFactory();
        runtask(inst);
    }

    public static void test2() {
        NewWorkStealingPoolDemo inst = NewWorkStealingPoolDemo.getThreadPoolInstWithThreadFactory(7);
        runtask(inst);

    }


    public static void main(String[] args) {

//        test1();
        test2();
    }

}
