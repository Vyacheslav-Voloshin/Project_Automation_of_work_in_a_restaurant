package project.kitchen;

import java.util.Observable;
import java.util.Observer;

//Клас waiter буде відносити закази до потрібного столика
//Cook(Кухар) готує замовлення, а Waiter їх обробляє.
public class Waiter implements Observer {

    @Override
    public void update(Observable cook, Object arg) {
        System.out.println(arg + " was cooked by " + cook);
    }
}
