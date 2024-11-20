package telran.multithreading;

public class Racer extends Thread {
    private Race race;
    private int number;

    public Racer(Race race, int number) {
        this.race = race;
        this.number = number;
    }

    @Override
    public void run() {
        // Running cycle containing number of iterations from the Race reference as the
        // distance
        // Each iteration is printing out the number of the thread for game tracing to
        // see game dynamics
        int timeOut = race.getRandomSleepTimeOut();
        int distance = race.getDistance();
        
        for (int i = 0; i < distance; i++) {
            System.out.println("Racer #" + number);
            try {
                Thread.sleep(timeOut);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        if (race.getWinner() == 0) {
            race.setWinner(number);
        }
    }
}
