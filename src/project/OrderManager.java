package project;

import project.kitchen.Order;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.LinkedBlockingQueue;

public class OrderManager implements Observer {

    private  LinkedBlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>(200);

    @Override
    public void update(Observable o, Object arg) {
        orderQueue.add((Order) arg);
    }
}
