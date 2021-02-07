package org.kodluyoruz;

import java.util.concurrent.SynchronousQueue;

public class Customer implements Runnable{

    private int id;
    Waiter waiter;
    private SynchronousQueue<Plate> placeSetting = new SynchronousQueue<Plate>();


    public Customer(Waiter waiter) {

        this.waiter = waiter;
    }

    public Customer(int id,Waiter waiter) {
        this.id = id;
        this.waiter = waiter;
    }

    public Customer() {

    }

    public Customer(int id) {

        this.id = id;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public void deliver(Plate p) throws InterruptedException {
        placeSetting.put(p);
    }

    @Override
    public void run() {
        System.out.println("Customer" + id + " is coming in restaurant");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("Customer" + id + " is leaving in restaurant");

    }

}