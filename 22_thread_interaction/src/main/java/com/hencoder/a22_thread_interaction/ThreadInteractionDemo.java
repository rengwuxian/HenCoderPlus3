package com.hencoder.a22_thread_interaction;

public class ThreadInteractionDemo implements TestDemo {

    @Override
    public void runTest() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 1_000_000; i++) {
                    System.out.println("number: " + i);
                }
            }
        };
        thread.start();
    }
}