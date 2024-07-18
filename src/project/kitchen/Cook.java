package project.kitchen;

import project.statistic.StatisticManager;
import project.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.Observer;

//Клас повар, який буде готувати для нас
public class Cook extends Observable {

    private String name;

    public Cook(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public void startCookingOrder(Order order){
        System.out.println("Start cooking - " + order);
        setChanged();
        notifyObservers(order);
        CookedOrderEventDataRow cookedOrderEventDataRow = new CookedOrderEventDataRow(order.getTablet().toString(),name,order.getTotalCookingTime()*60,order.getDishes());
        StatisticManager.getInstance().register(cookedOrderEventDataRow);
    }
}
