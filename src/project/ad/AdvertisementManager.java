package project.ad;
// � ������� �������� ���� ��� ��'��� ���������,
// ���� ���� �������� ����������� ���� ������ �
// ���� ����������� ��� ������� ����������.
//³� ����� ���� ��������� � ������ �� ������������ ������.
public class AdvertisementManager {

    final AdvertisementStorage storage = AdvertisementStorage.getInstance();

    private int timeSeconds; //��� ��������� ������ � ��������

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    //����� �������� �������� ����.
    public void processVideos(){
        System.out.println("calling processVideos method");
    }
}
