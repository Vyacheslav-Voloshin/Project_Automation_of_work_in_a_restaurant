package project.kitchen;

import java.util.Observable;
import java.util.Observer;

//���� waiter ���� �������� ������ �� ��������� �������
//Cook(�����) ���� ����������, � Waiter �� ��������.
public class Waiter implements Observer {

    @Override
    public void update(Observable cook, Object arg) {
        System.out.println(arg + " was cooked by " + cook);
    }
}
