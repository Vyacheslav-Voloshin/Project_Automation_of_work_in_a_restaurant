package project;

import java.util.List;

public class RandomOrderGeneratorTask implements Runnable{

    private List<Tablet> tabletList;
    private int interval;

    public RandomOrderGeneratorTask(List<Tablet> tabletList, int interval) {
        this.tabletList = tabletList;
        this.interval = interval;
    }

    @Override
    public void run() {
            try {
                while (true) {
                    int k = (int) (Math.random() * tabletList.size());
                    Tablet tablet = tabletList.get(k);
                    tablet.createTestOrder();
                    Thread.sleep(interval);
                }
            } catch (InterruptedException e){

            }

        }

}
