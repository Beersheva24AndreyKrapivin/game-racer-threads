package telran.multithreading;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class Race {
    // Fields and methods for Race parameters
    // min_sleep_timeout, max_sleep_time for getting some random sleep value in each
    // iteration as random factor for racer-winner definition
    // distance - number of iterations
    // any others possible fields
    private static final int MIN_SLEEP_TIMEOUT = 10;
    private static final int MAX_SLEEP_TIMEOUT = 100;

    private static AtomicInteger winner = new AtomicInteger(0);
    private int distance;

    public Race(int distance) {
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    public int getWinner() {
        return winner.get();
    }

    public void setWinner(int racerNumber) {
        winner.set(racerNumber);
    }

    public int getRandomSleepTimeOut() {
        return ThreadLocalRandom.current().nextInt(MIN_SLEEP_TIMEOUT, MAX_SLEEP_TIMEOUT);
    }
}
