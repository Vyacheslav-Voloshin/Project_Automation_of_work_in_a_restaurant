package project.statistic.event;

import project.ad.Advertisement;

import java.util.Date;
import java.util.List;

/*даний клас буде у€вл€ти собою под≥ю з енема.
ћи будемо реЇструвати даний  екземпл€р у сховищ≥.
 */
public class VideoSelectedEventDataRow  implements EventDataRow{

    private List<Advertisement> optimalVideoSet; // список в≥део ролик≥в в≥д≥браних дл€ показу

    private long amount; // сумма грошей в коп≥йках

    private int totalDuration; // загальна тривал≥сть показу в≥д≥браних в≥део ролик≥в

    private Date currentDate;
    public VideoSelectedEventDataRow(List<Advertisement> optimalVideoSet, long amount, int totalDuration) {
        this.optimalVideoSet = optimalVideoSet;
        this.amount = amount;
        this.totalDuration = totalDuration;
        this.currentDate = new Date();
    }


    @Override
    public EventType getType() {
        return EventType.SELECTED_VIDEOS;
    }
}
