package com.hencoder.a22_thread_interaction;

public class CustomizableThreadDemo implements TestDemo {
    private CustomizableThread thread = new CustomizableThread();

    @Override
    public void runTest() {
        thread.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    class CustomizableThread extends Thread {
        @Override
        public void run() {
            while (true) {
            }
        }
    }
}
