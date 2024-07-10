package project.kitchen;

import project.statistic.StatisticManager;
import project.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.Observer;

//Клас повар, який буде готувати для нас
public class Cook extends Observable implements Observer {

    private String name;

    public Cook(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void update(Observable o, Object arg) {
        Order order = (Order) arg;
        System.out.println("Start cooking - " + arg);
        setChanged();
        notifyObservers(order);
        CookedOrderEventDataRow cookedOrderEventDataRow = new CookedOrderEventDataRow(order.getTablet().toString(),name,order.getTotalCookingTime()*60,order.getDishes());
        StatisticManager.getInstance().register(cookedOrderEventDataRow);
    }
}
