package project.statistic;

import project.statistic.event.EventDataRow;
import project.statistic.event.EventType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*За допомогою цього класу ми будемо реєструвати події в сховищі
   Ми маємо одне сховище з однією точкою входу.
   Тому зробимо StatisticManager синглтоном.
 */
public class StatisticManager {
    private static StatisticManager ourInstance = new StatisticManager();

    public static StatisticManager getInstance() {
        return ourInstance;
    }
    /*Щоб менеджер міг отримати доступ до сховища,
 потрібно в класі StatisticManager створити поле statisticStorage
 типу StatisticStorage.

     */
    private StatisticStorage statisticStorage = new StatisticStorage();

    private StatisticManager(){}


    //метод void register(Event Data Row data), який реєструватиме
    //подію у сховищі.
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
    //метод додає обєкт data в дані Map storage
        private void put(EventDataRow data){
            EventType type = data.getType();
            if (!this.storage.containsKey(type))
                throw new UnsupportedOperationException();
            this.storage.get(type).add(data);
        }
    }
   }
