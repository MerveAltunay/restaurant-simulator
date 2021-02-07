package org.kodluyoruz;

class Order {

    private int id;
    Customer customer;
    Waiter waiter;

    Order(Customer customer, Waiter waiter) {
        this.customer = customer;
        this.waiter = waiter;
    }

    public String toString() {

        return "Order: " + id + " for: " + customer + " served by " + waiter;
    }
}
