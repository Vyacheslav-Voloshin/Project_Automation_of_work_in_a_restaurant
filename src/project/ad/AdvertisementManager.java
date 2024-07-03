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

    /*����� �������� �������� ����:
       1 ϳ������ ������ ���� � ���������, �������� ���� ��������� ����������� ������.
       2 ���� ���� ��������� ����, �� ����� �������� ����������,
           �� ������ NoVideoAvailableException,��� ���������� �
           ������������ ���� �� � ����� Level.INFO �������� �����
           "No video is available for the order " + order
       3 ³��������� �� ������� ������, ������ ��� ������,
            � ������� ��������� ������� ������ ������ ����������
            ������ � �������. �������� ���������� -
            ��������� ������� ������ ���� ������� ����������
            ������ � �������� �������� ������. ������������ ������ Collections.sort
     */
    public void processVideos() throws NoVideoAvailableException {
        if (storage.list().isEmpty()){
            throw new NoVideoAvailableException();
        }

    }
}
