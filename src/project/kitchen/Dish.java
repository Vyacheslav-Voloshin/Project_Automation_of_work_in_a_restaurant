package project.kitchen;

public enum Dish {
    FISH(25),
    STEAK(30),
    SOUP(15),
    JUICE(5),
    WATER(3);

    private int duration; //поле час виготовлення страви в хвилинах

    Dish(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }


    //Метод, який відображає для користувача страви
    public static String allDishesToString(){
        String result = "";
        for (Dish dish : Dish.values()) {
            if ("".equals(result)){
                result+=dish.name();
            } else {
                result+=", "+dish.name();
            }
        }
        return result;
    }
}
