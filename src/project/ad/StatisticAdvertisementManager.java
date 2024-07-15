package project.ad;

import java.util.ArrayList;
import java.util.List;

/*
Клас, який буде надавати інформацію з AdvertisementStorage в
 потрібному нам вигляді.
 */
public class StatisticAdvertisementManager {
    private static StatisticAdvertisementManager ourInstance = new StatisticAdvertisementManager();

    public static StatisticAdvertisementManager getInstance(){
        return ourInstance;
    }
    private StatisticAdvertisementManager() {
    }



    AdvertisementStorage advertisementStorage = AdvertisementStorage.getInstance();

    //метод повертає список активних фбо неактивних відеороліків
    public List<Advertisement>  getAdvertisementList(boolean bbb){
        List<Advertisement> list = advertisementStorage.videos;
        List<Advertisement>activeList = new ArrayList<>();
        for (Advertisement ad:list) {
            if (ad.isActive()==bbb){
                activeList.add(ad);
            }
        }
        return activeList;
    }
}
