package project;

import java.util.List;

public class RandomOrderGeneratorTask implements Runnable{

    private List<Tablet> tablets;
    private int interval;

    public RandomOrderGeneratorTask(List<Tablet> tabletList, int interval) {
        this.tablets = tabletList;
        this.interval = interval;
    }

    @Override
    public void run() {
            try {
                while (true) {
                    int k = (int) (Math.random() * tablets.size());
                    Tablet tablet = tablets.get(k);
                    tablet.createTestOrder();
                    Thread.sleep(interval);
                }
            } catch (InterruptedException e){

            }

        }

}
