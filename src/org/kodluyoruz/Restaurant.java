package org.kodluyoruz;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Restaurant implements Runnable {

    private List<Waiter> waiters = new ArrayList<Waiter>();
    private List<Chef> chefs = new ArrayList<Chef>();
    private ExecutorService exec;
    private static Random rand = new Random();
    BlockingQueue<Order> orders = new LinkedBlockingQueue<Order>();

    public Restaurant(ExecutorService e, int nWaiter, int nChefs) {
        exec = e;
        for (int i = 0; i < nWaiter; i++) {
            Waiter waiter = new Waiter(this);
            waiters.add(waiter);
            exec.execute(waiter);
        }

        for(int i=0;i<nChefs;i++) {
            Chef chef = new Chef(this);
            chefs.add(chef);
            exec.execute(chef);
        }

    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                Waiter waiter = waiters.get(rand.nextInt(waiters.size()));
                Customer c = new Customer(waiter);
                exec.execute(c);
                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println("Restaurant interrupted");
        }
        System.out.println("Restaurant closing");
    }

}
