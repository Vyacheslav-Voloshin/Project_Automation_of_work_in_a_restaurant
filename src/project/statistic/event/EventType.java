package project.statistic.event;

public enum EventType {
    COOKED_ORDER,  //повар приготував замовлення
    SELECTED_VIDEOS, //обрали набір відео роликів для замовлення
    NO_AVAILABLE_VIDEO; //немає жодного відео-ролика, який можна показати під час приготування замовлення
}
