package project.statistic.event;

import java.util.Date;

/* інтерфейсом-маркером,
 т.к. не містить методів, і по ньому ми визначаємо,
є переданий об'єкт подією чи ні.
 */
public interface EventDataRow {
     EventType getType();

     //реалізація цього методу поверне дату створення запису;
     Date getDate();

     //реалізація цього методу поверне час чи тривалість.
     int getTime();
}
