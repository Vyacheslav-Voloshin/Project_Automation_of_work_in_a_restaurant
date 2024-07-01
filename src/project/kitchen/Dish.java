package project.kitchen;

public enum Dish {
    FISH,
    STEAK,
    SOUP,
    JUICE,
    WATER;
//Метод, який відображає для користувача страви
    public static String allDishesToString(){
        return "FISH, STEAK, SOUP, JUICE, WATER";
    }
}
