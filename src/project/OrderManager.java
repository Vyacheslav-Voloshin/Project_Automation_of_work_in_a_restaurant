package project;

import project.kitchen.Cook;
import project.kitchen.Order;
import project.statistic.StatisticManager;

import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
/*
������� ���, ��� OrderManager �������� ����-����� ������� ������ ��
������� ���� ����������. ��� ��������� ���� ����� ��� �����������
 �����-����. ³� ����������� �������� ��������� � ����,
 ������� ������ ������ � ���������� �� ����������.
 */
public class OrderManager implements Observer{

    private  LinkedBlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>(200);

    public OrderManager(){
        Thread thread = new Thread(){
            @Override
            public void run() {
                Set<Cook> setCooks = StatisticManager.getInstance().getCooks();
                while (true) {
                    try {
                        Thread.sleep(10);
                        if (!orderQueue.isEmpty()) {
                            for (Cook cook : setCooks) {
                                if (!cook.busy) {
                                    cook.startCookingOrder(orderQueue.take());
                                }
                            }
                        }

                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
        thread.setDaemon(true);
        thread.start();
    }

    @Override
    public void update(Observable o, Object arg) {
        orderQueue.add((Order) arg);
    }
}
