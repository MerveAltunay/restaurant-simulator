package org.kodluyoruz;

public class Chef extends Waiter implements Runnable{


    private int id;
    private Waiter waiter;
    private Restaurant restaurant;


    public Chef(int id,Waiter waiter) {
        super();
        this.id = id;
        this.waiter = waiter;
    }

    public Chef(Restaurant restaurant) {

        this.restaurant = restaurant;
    }

    public Chef(int i) {
        this.id = id;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Chef" + this.id + " received the order from Waiter" + waiter.getId());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("Chef " + this.id + " prepared the order and gave it to the Waiter " + waiter.getId());

    }
}