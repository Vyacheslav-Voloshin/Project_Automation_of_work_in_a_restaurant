package project.kitchen;

import project.Tablet;

import java.util.List;

//� ���� Order (����������) �� ���� ����������,
//�� ���������� �� ������ �������� ������������ �����.
//����� �� ���� ������ ��� �����, � �� ���� ������
//�������� ����� � ���� Order.
public class Order {

    private final Tablet tablet;
    protected List<Dish> dishes;

    public Order(Tablet tablet) {
        this.tablet = tablet;
    }
}
