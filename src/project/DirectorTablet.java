package project;

import project.ad.Advertisement;
import project.ad.StatisticAdvertisementManager;
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
    public void printActiveVideoSet(){
        StatisticAdvertisementManager statisticAdvertisementManager = StatisticAdvertisementManager.getInstance();
        List<Advertisement> list = statisticAdvertisementManager.getAdvertisementList(true);
        Collections.sort(list, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                return o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase());
            }
        });
        for (Advertisement ad:list) {
            System.out.println(ad.getName() + " - "+ad.getHits());
        }

    }

    //������ ���������� ������
    public void printArchivedVideoSet(){
        StatisticAdvertisementManager statisticAdvertisementManager = StatisticAdvertisementManager.getInstance();
        List<Advertisement> list = statisticAdvertisementManager.getAdvertisementList(false);
        Collections.sort(list, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                return o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase());
            }
        });
        for (Advertisement ad:list) {
            System.out.println(ad.getName());
        }
    }





}
