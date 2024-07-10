package project.statistic.event;
/* інтерфейсом-маркером,
 т.к. не містить методів, і по ньому ми визначаємо,
є переданий об'єкт подією чи ні.
 */
public interface EventDataRow {
     public EventType getType();
}
