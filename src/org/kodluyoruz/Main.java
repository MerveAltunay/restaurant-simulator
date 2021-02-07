package org.kodluyoruz;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws IOException {

        ExecutorService exec = Executors.newFixedThreadPool(5);
        ExecutorService waiterExecutor = Executors.newFixedThreadPool(3);
        ExecutorService chefExecutor = Executors.newFixedThreadPool(2);

        Random random = new Random();
        int customerNumber = random.nextInt(20);

        for(int i=1;i<=customerNumber;i++){

            exec.submit(new Customer(i,new Waiter(i)));

        }
        for(int i=1;i<=3;i++) {
            waiterExecutor.submit(new Waiter(i, new Customer(i), new Chef(i)));
        }

        for(int i=1;i<=2;i++) {
            chefExecutor.submit(new Chef(i, new Waiter(i)));
        }

        exec.shutdown();
        waiterExecutor.shutdown();
        chefExecutor.shutdown();

        try{
            exec.awaitTermination(30, TimeUnit.SECONDS);
            waiterExecutor.awaitTermination(30, TimeUnit.SECONDS);
            chefExecutor.awaitTermination(30, TimeUnit.SECONDS);
        }
        catch (InterruptedException ex){

        }
        System.out.println("All customer is leaved in restaurant");

    }
}