package project.statistic.event;

import project.kitchen.Dish;

import java.util.Date;
import java.util.List;
/*����� ���� ���� ������� ����� ���� � �����.
�� ������ ���������� �����  ��������� � �������.
 */
public class CookedOrderEventDataRow implements EventDataRow {

    private String tabletName; //��� ��������
    private String cookName;   // ��� ������
    private int cookingTimeSeconds;   // ��� ������������ ���������� � ��������
    private List<Dish> cookingDishes; //������ ����� ��� ������������

    private Date currentDate;


    public CookedOrderEventDataRow(String tabletName, String cookName, int cookingTimeSeconds, List<Dish> cookingDishes) {
        this.tabletName = tabletName;
        this.cookName = cookName;
        this.cookingTimeSeconds = cookingTimeSeconds;
        this.cookingDishes = cookingDishes;
        this.currentDate = new Date();
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public int getCookingTimeSeconds() {
        return cookingTimeSeconds;
    }

    @Override
    public EventType getType() {
        return EventType.COOKED_ORDER;
    }

    @Override
    public Date getDate() {
        return getCurrentDate();
    }

    @Override
    public int getTime() {
        return getCookingTimeSeconds();
    }
}
