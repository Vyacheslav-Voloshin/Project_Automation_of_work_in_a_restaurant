package project.statistic.event;

import java.util.Date;

/* �����������-��������,
 �.�. �� ������ ������, � �� ����� �� ���������,
� ��������� ��'��� ��䳺� �� �.
 */
public interface EventDataRow {
     EventType getType();

     //��������� ����� ������ ������� ���� ��������� ������;
     Date getDate();

     //��������� ����� ������ ������� ��� �� ���������.
     int getTime();
}
