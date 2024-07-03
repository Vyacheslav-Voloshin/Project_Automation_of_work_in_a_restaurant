package project.ad;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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
    public void processVideos() {
        this.totalTimeSecondsLeft = Integer.MAX_VALUE;
        obtainOptimalVideoSet(new ArrayList<>(), timeSeconds, 0L);

        displayAdvertisement();
    }

    //recursion
    private long maxAmount;
    private List<Advertisement> optimalVideoSet;
    private int totalTimeSecondsLeft;

    private void obtainOptimalVideoSet(List<Advertisement> totalList, int currentTimeSecondsLeft, long currentAmount) {
        if (currentTimeSecondsLeft < 0) {
            return;
        } else if (currentAmount > maxAmount
                || currentAmount == maxAmount && (totalTimeSecondsLeft > currentTimeSecondsLeft
                || totalTimeSecondsLeft == currentTimeSecondsLeft && totalList.size() < optimalVideoSet.size())) {
            this.totalTimeSecondsLeft = currentTimeSecondsLeft;
            this.optimalVideoSet = totalList;
            this.maxAmount = currentAmount;
            if (currentTimeSecondsLeft == 0) {
                return;
            }
        }

        ArrayList<Advertisement> tmp = getActualAdvertisements();
        tmp.removeAll(totalList);
        for (Advertisement ad : tmp) {
            if (!ad.isActive()) continue;
            ArrayList<Advertisement> currentList = new ArrayList<>(totalList);
            currentList.add(ad);
            obtainOptimalVideoSet(currentList, currentTimeSecondsLeft - ad.getDuration(), currentAmount + ad.getAmountPerOneDisplaying());
        }
    }

    private ArrayList<Advertisement> getActualAdvertisements() {
        ArrayList<Advertisement> advertisements = new ArrayList<>();
        for (Advertisement ad : storage.list()) {
            if (ad.isActive()) {
                advertisements.add(ad);
            }
        }
        return advertisements;
    }

    private void displayAdvertisement() {
        if (optimalVideoSet == null || optimalVideoSet.isEmpty()) {
            throw new NoVideoAvailableException();
        }

        optimalVideoSet.sort((o1, o2) -> {
            long l = o2.getAmountPerOneDisplaying() - o1.getAmountPerOneDisplaying();
            return (int) (l != 0 ? l : o2.getDuration() - o1.getDuration());
        });

        for (Advertisement ad : optimalVideoSet) {
            displayInPlayer(ad);
            ad.revalidate();
        }
    }

    private void displayInPlayer(Advertisement advertisement) {
        System.out.println(advertisement.getName() + " is displaying... " + advertisement.getAmountPerOneDisplaying() +
                ", " + (1000 * advertisement.getAmountPerOneDisplaying() / advertisement.getDuration()));
    }



}
