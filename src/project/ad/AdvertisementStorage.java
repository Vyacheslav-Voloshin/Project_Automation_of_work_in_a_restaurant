package project.ad;

import java.util.ArrayList;
import java.util.List;

// ���� ������� ��������� ������.
//������� ������� ��������� ������ AdvertisementStorage
//����� ��� ���������, �� ������� ���� ����������.
public class AdvertisementStorage {
    private static class InstanceHolder {
        private static final AdvertisementStorage ourInstance = new AdvertisementStorage();
    }

    public static AdvertisementStorage getInstance() {
        return InstanceHolder.ourInstance;
    }

    private AdvertisementStorage() {
        Object someContent = new Object();
        videos.add(new Advertisement(someContent, "First Video", 5000, 100, 3 * 60));// 3 min
        videos.add(new Advertisement(someContent, "Second Video", 100, 10, 15 * 60)); //15 min
        videos.add(new Advertisement(someContent, "Third Video", 400, 2, 10 * 60)); //10 min
    }

    final  List<Advertisement> videos = new ArrayList<>();


    // ������� ������ ��������� ����
    public List<Advertisement> list(){
        return videos;
    }

    //����� ���� ���� ���� �� ������
    public void add(Advertisement advertisement){
        videos.add(advertisement);
    }
}
