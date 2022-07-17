package com.minfengyu.day13;

import java.util.ArrayList;
import java.util.concurrent.*;

public class TaskWithResult implements Callable<String> {
    private String id;

    public TaskWithResult(String id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        return "result id="+id;
    }
}
 class CallableTest{
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>> futures = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            futures.add(exec.submit(new TaskWithResult(i+"")));
        }
        for (Future<String> future : futures) {
            if (future.isDone()){
                System.out.println(future.get());
            }else {
                System.out.println("Futer result is not return");
            }
        }

    }
}
