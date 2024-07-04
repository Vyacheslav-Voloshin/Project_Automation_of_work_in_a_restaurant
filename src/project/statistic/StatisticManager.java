package project.statistic;

import project.statistic.event.EventDataRow;

/*За допомогою цього класу ми будемо реєструвати події в сховищі
   Ми маємо одне сховище з однією точкою входу.
   Тому зробимо StatisticManager синглтоном.
 */
public class StatisticManager {
    private static  class InstanceHolder {
        private static final StatisticManager ourInstance = new StatisticManager();
    }
    public static StatisticManager getInstance(){
        return InstanceHolder.ourInstance;
    }

    private StatisticManager(){}


    //метод void register(Event Data Row data), який реєструватиме
    //подію у сховищі.
   public void register(EventDataRow data){

   }
}
