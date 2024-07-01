package project.kitchen;

public enum Dish {
    FISH,
    STEAK,
    SOUP,
    JUICE,
    WATER;
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
