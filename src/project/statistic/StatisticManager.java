package project.statistic;

import project.kitchen.Cook;
import project.statistic.event.CookedOrderEventDataRow;
import project.statistic.event.EventDataRow;
import project.statistic.event.EventType;
import project.statistic.event.VideoSelectedEventDataRow;

import java.text.SimpleDateFormat;
import java.util.*;

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

    private Set<Cook> cooks = new HashSet<>();

    private StatisticManager(){}

    public Set<Cook> getCooks() {
        return cooks;
    }

    //метод void register(Event Data Row data), який реєструватиме
    //подію у сховищі.
   public void register(EventDataRow data){
        this.statisticStorage.put(data);
   }

   //метод void register(Cook cook), який реєструватиме повара в Set
   public void register(Cook cook){
        this.cooks.add(cook);
   }


   //метод рахує загальний прибутоквід реклами за кожний день
   public Map<String,Long> profitForEveryDay(){
        Map<String,Long> res = new HashMap<>();
       List<EventDataRow> list = statisticStorage.storage.get(EventType.SELECTED_VIDEOS);
       SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy",Locale.ENGLISH);
       long total = 0l;
       for (EventDataRow row:list) {
           VideoSelectedEventDataRow row1 = (VideoSelectedEventDataRow) row;
           String date = dateFormat.format(row1.getDate());
           if (!res.containsKey(date)){
               res.put(date,0l);
           }
           total+=row1.getAmount();
           res.put(date,res.get(date)+ row1.getAmount());
       }
       res.put("Total",total);
       return res;
   }

    //метод рахує загальний загальний час роботи кожного повара
    public Map<String,Map<String,Integer>> getCookWorkloadingMap(){
        Map<String,Map<String,Integer>> res = new HashMap<>();
        List<EventDataRow>list = statisticStorage.storage.get(EventType.COOKED_ORDER);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy",Locale.ENGLISH);
        for (EventDataRow row:list) {
            CookedOrderEventDataRow row1 = (CookedOrderEventDataRow) row;
            String data = dateFormat.format(row1.getDate());
            if (!res.containsKey(data)){
                res.put(data,new HashMap<String, Integer>());
            }
            Map<String,Integer>cookMap = res.get(data);
            String cookName = row1.getCookName();
            if (!cookMap.containsKey(cookName)){
                cookMap.put(cookName,0);
            }
            Integer totalTime = row1.getCookingTimeSeconds();
            cookMap.put(cookName,totalTime+ row1.getCookingTimeSeconds());
        }
        return res;

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

    // метод який надає доступ до даних зі сховища
        private List<EventDataRow> get(EventType type) {
            if (!this.storage.containsKey(type))
                throw new UnsupportedOperationException();
            return this.storage.get(type);
        }


    }
   }
