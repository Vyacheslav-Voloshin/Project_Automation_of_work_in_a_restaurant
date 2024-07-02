package project;

import project.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {

    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));


 // ����� ��������  message � �������
    public static void writeMessage(String message){
        System.out.println(message);
    }

    // ����� ��� ������� ������ � ������
    public static String readString() throws IOException {
       return bufferedReader.readLine();
    }

    // ����� ������� ����������� ������� ������ �� ���� ���� �� ������.
    public static List<Dish> getAllDishesForOrder() throws IOException {
        List<Dish> dishList = new ArrayList<>();
        writeMessage(Dish.allDishesToString());
        writeMessage("���� ����� ������ ����� �����, ��� ������ ������:");
        writeMessage("��� ������ �� ���� ������ exit");
        while (true){
            String dishName = ConsoleHelper.readString().trim();
            if (dishName.equals("exit"))
                break;
            try {
                Dish dish = Dish.valueOf(dishName);
                dishList.add(dish);
                writeMessage(dishName + " ����� ���� ������ ������ �� ������ ����������");
            } catch (Exception e){
                writeMessage(dishName + " ���� ����� �� ������������ � ����");
            }
        }
        return dishList;
    }

}
