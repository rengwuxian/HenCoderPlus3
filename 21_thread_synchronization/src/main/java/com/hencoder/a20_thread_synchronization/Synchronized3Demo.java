package com.hencoder.a20_thread_synchronization;

public class Synchronized3Demo implements TestDemo {

    private int x = 0;
    private int y = 0;
    private String name;
    private final Object monitor = new Object();

    private void count(int newValue) {
        synchronized (this) {
            x = newValue;
            y = newValue;
        }
    }

    private synchronized void minus(int delta) {
        x -= delta;
        y -= delta;
    }

    private void setName(String newName) {
        synchronized (monitor) {
            name = newName;
        }
    }

    @Override
    public void runTest() {

    }
}
