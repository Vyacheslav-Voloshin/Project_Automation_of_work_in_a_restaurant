package project.ad;
// ���� ������������ �� �������
public class Advertisement {

    private Object content; //����� ����
    private String name; // ���/�����
    private long initialAmount; // ��������� ���� ������� ������� � �������
    private int hits; //������� ����������� ������
    private int duration; // ��������� ����� � ��������

    private long amountPerOneDisplaying; // ������� ������ ������ ����� � �������

    public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;
        if (hits>0)  this.amountPerOneDisplaying = initialAmount/hits;
    }

    public int getDuration() {
        return duration;
    }

    public long getAmountPerOneDisplaying() {
        return amountPerOneDisplaying;
    }

    public String getName() {
        return name;
    }

    public int getHits() {
        return hits;
    }

    /* ����� ������� ������ UnsupportedOperationException,
          ���� ������� ������ �� � ���������� ������. ���������� ������� ������.

         */
    public void revalidate(){
        if (hits==0)  throw new NoVideoAvailableException();
        hits--;

    }
    public boolean isActive() {
        return hits > 0;
    }
}
