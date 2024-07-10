package project.ad;
//  лас в≥дпов≥дальний за рекламу
public class Advertisement {

    private Object content; //зм≥нна в≥део
    private String name; // ≥м€/назва
    private long initialAmount; // початкова сума вартост≥ реклами в коп≥йках
    private int hits; //к≥льк≥сть проплачених показ≥в
    private int duration; // тривал≥сть рол≥ка в секундах

    private long amountPerOneDisplaying; // варт≥сть одгого показу рол≥ка в коп≥йках

    public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;
        if (hits>0)  this.amountPerOneDisplaying = initialAmount/hits;
    }

    public int getDuration() {
        return duration;
    }

    public long getAmountPerOneDisplaying() {
        return amountPerOneDisplaying;
    }

    public String getName() {
        return name;
    }


    /* ћетод повинен кинути UnsupportedOperationException,
      €кщо к≥льк≥сть показ≥в не Ї позитивним числом. «меншувати к≥льк≥сть показ≥в.

     */
    public void revalidate(){
        if (hits==0)  throw new NoVideoAvailableException();
        hits--;

    }
    public boolean isActive() {
        return hits > 0;
    }
}
