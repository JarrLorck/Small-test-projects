package com.jc;

import java.util.Random;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Random r = new Random();
	    int count = args.length >= 2 ? Integer.valueOf(args[1]) : 10;
        boolean isDaemon = args.length >= 1 ? Boolean.valueOf(args[0]) : false;

        for (int i = 0; i < count; i++) {
            Thread thread = new Thread(Thread.currentThread().getThreadGroup(), () -> {
                try {
                    while(true) {
                        System.err.println(Thread.currentThread().getName() + r.nextInt());
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },
                    "Thread" + i);
            thread.setDaemon(isDaemon);
            thread.start();
        }

//        Thread.currentThread().join();
    }
}
