package project;

import project.ad.AdvertisementManager;
import project.ad.AdvertisementStorage;
import project.kitchen.Cook;
import project.kitchen.Dish;
import project.kitchen.Order;
import project.kitchen.Waiter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Restaurant {

    private static final int ORDER_CREATING_INTERVAL = 100;

    public static void main(String[] args) throws IOException {
        Tablet tablet = new Tablet(5);
        Cook cook = new Cook("Slonenok");
        DirectorTablet directorTablet = new DirectorTablet();
        Waiter waiter = new Waiter();
        tablet.addObserver(cook);
        //tablet.createOrder();
        ///tablet.createTestOrder();
        cook.addObserver(waiter);
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();
    }
}
