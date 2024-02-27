package ru.abuklov133.com;

public class ATM {
    private static int cash = 1000;
    private final Object monitor = new Object();

    public void withdrew(String name, int amount) {
        synchronized (monitor) {
            System.out.println(name + " went to the ATM");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (cash >= amount) {
                cash = cash - amount;
                System.out.println(name + " withdrew " + amount
                        + " in rubles.\nRemaining amount :" + cash);
            } else {
                System.out.println("There is not enough money for " + name);
            }
        }
    }
}


