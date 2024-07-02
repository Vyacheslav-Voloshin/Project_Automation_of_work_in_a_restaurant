package project;

import project.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {

    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));


 // Метод виводить  message в консоль
    public static void writeMessage(String message){
        System.out.println(message);
    }

    // Метод для читання строки з консолі
    public static String readString() throws IOException {
       return bufferedReader.readLine();
    }

    // Метод просить користувача вибрати страву та додає його до списку.
    public static List<Dish> getAllDishesForOrder() throws IOException {
        List<Dish> dishList = new ArrayList<>();
        writeMessage(Dish.allDishesToString());
        writeMessage("Будь ласка введіть назву блюда, яку бажаєте обрати:");
        writeMessage("Для виходу із меню введіть exit");
        while (true){
            String dishName = ConsoleHelper.readString().trim();
            if (dishName.equals("exit"))
                break;
            try {
                Dish dish = Dish.valueOf(dishName);
                dishList.add(dish);
                writeMessage(dishName + " блюдо було успішно додано до Вашого замовлення");
            } catch (Exception e){
                writeMessage(dishName + " дане блюдо не представлено в меню");
            }
        }
        return dishList;
    }

}
