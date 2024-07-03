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

    /*метод обробляє рекламне відео:
       1 Підібрати список відео з доступних, перегляд яких забезпечує максимальну вигоду.
       2 Якщо немає рекламних відео, які можна показати відвідувачеві,
           то кинути NoVideoAvailableException,яке перехопити в
           оптимальному місці та з рівнем Level.INFO логувати фразу
           "No video is available for the order " + order
       3 Відображати всі рекламні ролики, відібрані для показу,
            у порядку зменшення вартості показу одного рекламного
            ролика у копійках. Вторинне сортування -
            збільшення вартості показу однієї секунди рекламного
            ролика в тисячних частинах копійки. Використання методу Collections.sort
     */
    public void processVideos() throws NoVideoAvailableException {
        if (storage.list().isEmpty()){
            throw new NoVideoAvailableException();
        }

    }
}
