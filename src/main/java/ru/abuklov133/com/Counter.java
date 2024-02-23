package ru.abuklov133.com;

public class Counter {
    private Object monitor = new Object();
    private int value;

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void inc() {
        synchronized (monitor) {
            value++;
        }
    }

    public void dec() {
        synchronized (monitor) {
            value--;
        }
    }
}
