package project;

import project.kitchen.Cook;
import project.kitchen.Dish;
import project.kitchen.Order;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Restaurant {

    public static void main(String[] args) throws IOException {
        Tablet tablet = new Tablet(5);
        Cook cook = new Cook("Slonenok");
        tablet.addObserver(cook);
        tablet.createOrder();



    }
}
