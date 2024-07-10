package project.statistic;

import project.statistic.event.EventDataRow;
import project.statistic.event.EventType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*�� ��������� ����� ����� �� ������ ���������� ��䳿 � �������
   �� ���� ���� ������� � ���� ������ �����.
   ���� ������� StatisticManager ����������.
 */
public class StatisticManager {
    private static StatisticManager ourInstance = new StatisticManager();

    public static StatisticManager getInstance() {
        return ourInstance;
    }
    /*��� �������� �� �������� ������ �� �������,
 ������� � ���� StatisticManager �������� ���� statisticStorage
 ���� StatisticStorage.

     */
    private StatisticStorage statisticStorage = new StatisticStorage();

    private StatisticManager(){}


    //����� void register(Event Data Row data), ���� ������������
    //���� � �������.
   public void register(EventDataRow data){
        this.statisticStorage.put(data);
   }

    private class StatisticStorage {
        private Map<EventType, List<EventDataRow>> storage = new HashMap<>();

        private StatisticStorage() {
            for (EventType type : EventType.values()) {
                this.storage.put(type, new ArrayList<EventDataRow>());
            }
        }
    //����� ���� ���� data � ��� Map storage
        private void put(EventDataRow data){
            EventType type = data.getType();
            if (!this.storage.containsKey(type))
                throw new UnsupportedOperationException();
            this.storage.get(type).add(data);
        }
    }
   }
