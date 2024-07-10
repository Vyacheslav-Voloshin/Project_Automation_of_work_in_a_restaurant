package project.statistic.event;

import project.ad.Advertisement;

import java.util.Date;
import java.util.List;

/*����� ���� ���� ������� ����� ���� � �����.
�� ������ ���������� �����  ��������� � �������.
 */
public class VideoSelectedEventDataRow  implements EventDataRow{

    private List<Advertisement> optimalVideoSet; // ������ ���� ������ �������� ��� ������

    private long amount; // ����� ������ � �������

    private int totalDuration; // �������� ��������� ������ �������� ���� ������

    private Date currentDate;
    public VideoSelectedEventDataRow(List<Advertisement> optimalVideoSet, long amount, int totalDuration) {
        this.optimalVideoSet = optimalVideoSet;
        this.amount = amount;
        this.totalDuration = totalDuration;
        this.currentDate = new Date();
    }

    public int getTotalDuration() {
        return totalDuration;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    @Override
    public EventType getType() {
        return EventType.SELECTED_VIDEOS;
    }

    @Override
    public Date getDate() {
        return getCurrentDate();
    }

    @Override
    public int getTime() {
        return getTotalDuration();
    }
}
