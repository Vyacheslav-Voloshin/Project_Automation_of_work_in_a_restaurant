package project.ad;
// клас сховище рекламних роликів.
//Оскільки сховище рекламних роликів AdvertisementStorage
//єдине для ресторану, то зробимо його синглтоном.
public class AdvertisementStorage {
    private static class InstanceHolder {
        private static final AdvertisementStorage ourInstance = new AdvertisementStorage();
    }

    public static AdvertisementStorage getInstance() {
        return InstanceHolder.ourInstance;
    }

    private AdvertisementStorage() {
    }
}
