package project;

import project.statistic.StatisticManager;
import project.statistic.event.EventDataRow;

import java.util.*;

/*
 �������� �� � ������� ���� ��������� �� ������.
���� ���� �������, ��� � ����� ���������� �������������.
��� ����� �������� ���� DirectorTablet,
� ����� ������ ������������� ��������� �� ��������� ���������
 �� ����������.
 */
public class DirectorTablet {

    //����� ������������, ��� ���� �������� �� ������, ���������� �����;
    public void printAdvertisementProfit(){
        StatisticManager statisticManager = StatisticManager.getInstance();
        Map<String,Long> map = statisticManager.profitForEveryDay();
        ArrayList<String> arrayList = new ArrayList(map.keySet());
        Collections.sort(arrayList);
        for (String key:arrayList) {
            double number = 1.0* map.get(key)/100;
            System.out.println(key+" - " + String.format(Locale.ENGLISH,"%.2f",number));
        }
    }

    // ����� ������������, ������������ (������� ���) ������, ���������� �� ����;
    public void printCookWorkloading(){
        StatisticManager statisticManager = StatisticManager.getInstance();
        Map<String,Map<String,Integer>> map = statisticManager.getCookWorkloadingMap();
        ArrayList<String> arrayList = new ArrayList(map.keySet());
        Collections.sort(arrayList);
        for (String date:arrayList) {
            Map<String,Integer> map1 = map.get(date);
            System.out.println(date);
            ArrayList<String>arrayList1 = new ArrayList<>(map1.keySet());
            Collections.sort(arrayList1);
            for (String name:arrayList1) {
                System.out.println(name + " - " + ((map1.get(name)+59)/60) + " min");
            }
        }
        System.out.println();
    }

    //������ �������� ������ � ������� ������, �� ����������, �� �������;
    public void printActiveVideoSet(){}

    //������ ���������� ������
    public void printArchivedVideoSet(){}





}
