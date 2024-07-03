package project.ad;
// У кожного планшета буде свій об'єкт менеджера,
// який буде підбирати оптимальний набір роликів і
// їхня послідовність для кожного замовлення.
//Він також буде взаємодіяти з плеєром та відображатиме ролики.
public class AdvertisementManager {

    final AdvertisementStorage storage = AdvertisementStorage.getInstance();

    private int timeSeconds; //час виконання заказу в секундах

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    //метод обробляє рекламне відео.
    public void processVideos(){
        System.out.println("calling processVideos method");
    }
}
