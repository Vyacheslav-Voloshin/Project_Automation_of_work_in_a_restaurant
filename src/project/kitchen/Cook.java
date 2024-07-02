package project.kitchen;

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
        System.out.println("Start cooking - " + arg);
        setChanged();
        notifyObservers(arg);
    }
}
