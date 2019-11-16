package com.wzh.crocodile.ex00_ready.thread.th01_test1;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * @Description: 实现Callable接口
 * Runnable是执行工作的独立任务，但是它不返回任何值。
 * 如果希望任务完成时能够返回一个值，那么应该实现Callable接口，而不是Runnable接口。
 * Callable是一种具有类型参数的泛型，他的类型参数表示的时从方法call()【而不是run()】中返回的值
 * 并且必须使用ExecutorService.submit()【而不是execute()】方法调用Callable
 * @Author: 吴智慧
 * @Date: 2019/11/16 16:13
 */
class TaskWithResult implements Callable<String> {

    private int id;

    public TaskWithResult(int id){
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        return "result of TaskWithResult " + id;
    }
}

/**
 * @Description: 从任务中产生返回值
 * @Author: 吴智慧
 * @Date: 2019/11/16 16:13
 */
public class CallableDemo{

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<Future<String>>();
        for (int i = 0; i < 10; i++){
            // submit()方法会产生Future对象，它用Callable返回结果的特定类型进行类参数化
            results.add(exec.submit(new TaskWithResult(i)));
        }
        // 不了解Future，可以看看相关博客
        // 我的收藏：https://www.cnblogs.com/cz123/p/7693064.html
        for (Future<String> fs : results){
            try {
                System.out.println(fs.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            } catch (ExecutionException e) {
                e.printStackTrace();
                return;
            }finally {
                exec.shutdown();
            }
        }
        // 可以使用isDone()方法查询Future是否完成，任务是否完成
        // 当任务完成时，返回一个结果，可以调用get()方法获取该结果
        // 如果任务还没完成，结果还未返回，get()方法将被阻塞，直至结果准备就绪
    }
}
