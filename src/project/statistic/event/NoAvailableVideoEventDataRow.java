package project.statistic.event;

import java.util.Date;

/*даний клас буде у€вл€ти собою под≥ю з енема.
ћи будемо реЇструвати даний  екземпл€р у сховищ≥.
 */
public class NoAvailableVideoEventDataRow implements EventDataRow {

    private int totalDuration; //час приготуванн€ заказа в секундах
    private Date currentDate;

    public NoAvailableVideoEventDataRow(int totalDuration) {
        this.totalDuration = totalDuration;
        this.currentDate = new Date();
    }

    @Override
    public EventType getType() {
        return EventType.NO_AVAILABLE_VIDEO;
    }
}
