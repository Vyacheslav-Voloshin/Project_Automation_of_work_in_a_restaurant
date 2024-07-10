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

    public Tablet getTablet() {
        return tablet;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        this.dishes = ConsoleHelper.getAllDishesForOrder();
        ConsoleHelper.writeMessage(toString());
    }

@Override
   public String toString() {
    StringBuilder result = new StringBuilder();
    if (dishes.size()==0) return result.toString();
    result.append( "Your order: [" + dishes.get(0));

    for (int i = 1; i < dishes.size(); i++) {
        result.append( ", " + dishes.get(i).name());
    }
    result.append( "] of " + tablet);
    result.append( ", cooking time "+getTotalCookingTime()+"min");
    return result.toString();
}
//�����, ���� ����� �������� ��� ������������ ��� ����� � ���������.
    public int getTotalCookingTime(){
        int res = 0;
        for (Dish dish:dishes) {
            res+= dish.getDuration();
        }
        return res;
    }
//�����, ���� �����������, �� � ���� ������ �� ����������.
    public boolean isEmpty(){
         return (dishes.isEmpty());
    }
}
