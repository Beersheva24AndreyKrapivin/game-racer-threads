package telran.multithreading;

import java.util.Random;

public class Racer extends Thread {
    private final Race race;
    private int number;
    private long finishTime = -1;

    public Racer(Race race, int number) {
        this.race = race;
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public long getFinishTime() {
        return finishTime;
    }

    @Override
    public void run() {
        int minSleep = race.getMinSleep();
        int maxSleep = race.getMaxSleep();
        int distance = race.getDistance();
        Random random = new Random();

        race.startTime.compareAndSet(-1l, System.currentTimeMillis());

        for (int i = 0; i < distance; i++) {
            try {
                Thread.sleep(random.nextInt(minSleep, maxSleep + 1));
                //System.out.println("Racer #" + number);
            } catch (InterruptedException e) {

            }
        }
        //finishTime = System.currentTimeMillis();
        synchronized (race) {
            fillWinnerList();
        }
    }

    private void fillWinnerList() {
        race.listWinner.add(this);
        finishTime = System.currentTimeMillis();
    }
}
