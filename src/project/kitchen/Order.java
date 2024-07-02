package project.kitchen;

import project.ConsoleHelper;
import project.Tablet;

import java.io.IOException;
import java.util.List;

//� ���� Order (����������) �� ���� ����������,
//�� ���������� �� ������ �������� ������������ �����.
//����� �� ���� ������ ��� �����, � �� ���� ������
//�������� ����� � ���� Order.
public class Order {

    private final Tablet tablet;
    protected List<Dish> dishes;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        this.dishes = ConsoleHelper.getAllDishesForOrder();
    }

    @Override
    public String toString() {
        if (dishes == null){
            return "";
        } else {
            return "Your order: "+dishes.toString() + " of " + tablet.toString();
        }
    }
}
