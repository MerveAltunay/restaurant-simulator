package org.kodluyoruz;

public class Waiter extends Customer implements Runnable{

    private int id;
    Customer customer;
    Chef chef;
    Restaurant restaurant;

    public Waiter(Restaurant restaurant) {

        this.restaurant = restaurant;
    }

    public Waiter(int id, Customer customer, Chef chef) {
        super();
        this.id = id;
        this.customer = customer;
        this.chef = chef;

    }

    public Waiter() {

    }

    public Waiter(int id) {

        this.id = id;
    }

    public void placeOrder(Customer customer) {
        try {
            restaurant.orders.put(new Order(customer,this));
        } catch (InterruptedException e) {
            System.out.println(this + " placeOrder interrupted");
        }
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    @Override
    public void run() {

        System.out.println("Waiter" + id + " took the order from Customer" + customer.getId());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}