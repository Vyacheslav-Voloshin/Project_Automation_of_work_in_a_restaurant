package project.statistic.event;

import java.util.Date;

/*����� ���� ���� ������� ����� ���� � �����.
�� ������ ���������� �����  ��������� � �������.
 */
public class NoAvailableVideoEventDataRow implements EventDataRow {

    private int totalDuration; //��� ������������ ������ � ��������
    private Date currentDate;

    public NoAvailableVideoEventDataRow(int totalDuration) {
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
        return EventType.NO_AVAILABLE_VIDEO;
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
