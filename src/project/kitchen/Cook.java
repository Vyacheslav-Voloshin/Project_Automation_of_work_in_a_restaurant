package project.kitchen;

import project.Restaurant;
import project.statistic.StatisticManager;
import project.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

//Клас повар, який буде готувати для нас
public class Cook extends Observable implements Runnable {

    private String name;

    public boolean busy;

    private LinkedBlockingQueue<Order> queue;

    public Cook(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public boolean isBusy() {
        return busy;
    }

    public void setQueue(LinkedBlockingQueue<Order> queue) {
        this.queue = queue;
    }

    public LinkedBlockingQueue<Order> getQueue() {
        return queue;
    }

    public void startCookingOrder(Order order){
        busy = true;
        System.out.println("Start cooking - " + order);
        setChanged();
        notifyObservers(order);
        try {
            Thread.sleep(10*order.getTotalCookingTime());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        CookedOrderEventDataRow cookedOrderEventDataRow = new CookedOrderEventDataRow(order.getTablet().toString(),name,order.getTotalCookingTime()*60,order.getDishes());
        StatisticManager.getInstance().register(cookedOrderEventDataRow);
        busy = false;
    }

    @Override
    public void run() {
            try {
                while (true) {
                    Thread.sleep(10);
                    if (!queue.isEmpty()) {
                            if (!this.busy) {
                                this.startCookingOrder(queue.take());
                            }
                        }
                    }
                } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
    }

}
