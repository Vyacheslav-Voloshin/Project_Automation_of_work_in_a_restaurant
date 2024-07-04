package project.statistic;

import project.statistic.event.EventDataRow;

/*�� ��������� ����� ����� �� ������ ���������� ��䳿 � �������
   �� ���� ���� ������� � ���� ������ �����.
   ���� ������� StatisticManager ����������.
 */
public class StatisticManager {
    private static  class InstanceHolder {
        private static final StatisticManager ourInstance = new StatisticManager();
    }
    public static StatisticManager getInstance(){
        return InstanceHolder.ourInstance;
    }

    private StatisticManager(){}


    //����� void register(Event Data Row data), ���� ������������
    //���� � �������.
   public void register(EventDataRow data){

   }
}
