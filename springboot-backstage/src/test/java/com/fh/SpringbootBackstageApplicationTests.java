package com.fh;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootBackstageApplicationTests {

    public class Thread1 extends Thread{

        public void run(){
            super.run();
            System.out.println("执行了Thread的run方法");
        }

    }

    public class Thread2 implements Runnable{

        @Override
        public void run() {
            System.out.println("执行了Runnable的run方法");
        }
    }

    private class Thread3 implements Callable<String>{

        @Override
        public String call() throws Exception {

            System.out.println("执行了Runnable的run方法");
            Thread.sleep(5000);
            return "I am callable";
        }
    }

    @Test
    public void testThread() throws ExecutionException, InterruptedException {
        Thread1 thread1 = new Thread1();

        new Thread(thread1).start();

        Thread2 thread2 = new Thread2();
        new Thread(thread2).start();

        Thread3 thread3 = new Thread3();
        FutureTask<String> stk = new FutureTask<>(thread3);
        new Thread(stk).start();
        System.out.println(stk.get());

    }


}
