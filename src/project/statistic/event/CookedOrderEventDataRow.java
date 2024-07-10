package project.statistic.event;

import project.kitchen.Dish;

import java.util.Date;
import java.util.List;
/*даний клас буде у€вл€ти собою под≥ю з енума.
ћи будемо реЇструвати даний  екземпл€р у сховищ≥.
 */
public class CookedOrderEventDataRow implements EventDataRow {

    private String tabletName; //≥м€ планшету
    private String cookName;   // ≥м€ повара
    private int cookingTimeSeconds;   // час приготуванн€ замовленн€ в секундах
    private List<Dish> cookingDishes; //список страв дл€ приготуванн€

    private Date currentDate;


    public CookedOrderEventDataRow(String tabletName, String cookName, int cookingTimeSeconds, List<Dish> cookingDishes) {
        this.tabletName = tabletName;
        this.cookName = cookName;
        this.cookingTimeSeconds = cookingTimeSeconds;
        this.cookingDishes = cookingDishes;
        this.currentDate = new Date();
    }

    @Override
    public EventType getType() {
        return EventType.COOKED_ORDER;
    }
}
