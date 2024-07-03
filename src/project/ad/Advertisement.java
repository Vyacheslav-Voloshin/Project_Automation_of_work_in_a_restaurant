package project.ad;
// Клас відповідальний за рекламу
public class Advertisement {

    private Object content; //змінна відео
    private String name; // імя/назва
    private long initialAmount; // початкова сума вартості реклами в копійках
    private int hits; //кількість проплачених показів
    private int duration; // тривалість роліка в секундах

    public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;
    }


}
