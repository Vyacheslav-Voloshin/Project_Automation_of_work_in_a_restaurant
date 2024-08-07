package project;

import project.ad.AdvertisementManager;
import project.ad.NoVideoAvailableException;
import project.kitchen.Dish;
import project.kitchen.Order;
import project.kitchen.TestOrder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet  {

    private final int number; //�� ����� ��������, ��� ����� ���� ���������� ����������, ����� ������� ����������.

    private LinkedBlockingQueue<Order> queue;
    private static Logger logger = Logger.getLogger(Tablet.class.getName()); // ���� ��� ���������� ���������
    public Tablet(int number) {
        this.number = number;
    }

    public void setQueue(LinkedBlockingQueue<Order> queue) {
        this.queue = queue;
    }

    // ����� ������������ ���������� � ��� �����, �� ������ ����������
    public void createOrder(){
        Order order = null;
        try {
            order = new Order(this);
            processOrder(order);

        } catch (IOException e) {
            logger.log(Level.SEVERE,"Console is unavailable.");
        } catch (NoVideoAvailableException e){
            logger.log(Level.INFO,"No video is available for the order " + order);
        }
    }

    private boolean processOrder(Order order) {
        ConsoleHelper.writeMessage(order.toString());
        if (order.isEmpty()) return true;
        // setChanged();
        //notifyObservers(order);
        queue.offer(order);
        AdvertisementManager manager = new AdvertisementManager(order.getTotalCookingTime()*60);
        manager.processVideos();
        return false;
    }


    // ����� ������������ ���������� � ��� �����, �� ��� ����� �������� ����
    public void createTestOrder(){
        Order order = null;
        try {
            order = new TestOrder(this);
            processOrder(order);

        } catch (IOException e) {
            logger.log(Level.SEVERE,"Console is unavailable.");
        } catch (NoVideoAvailableException e){
            logger.log(Level.INFO,"No video is available for the order " + order);
        }
    }

    @Override
    public String toString() {
        return "Tablet{" +
                "number=" + number +
                '}';
    }
}
