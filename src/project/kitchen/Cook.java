package project.kitchen;

import project.statistic.StatisticManager;
import project.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.Observer;

//Клас повар, який буде готувати для нас
public class Cook extends Observable {

    private String name;

    public boolean busy;

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
}
