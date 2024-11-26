package telran.multithreading;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class Race {
    private int minSleep;
	private int maxSleep;
    private int distance;

    AtomicInteger winner = new AtomicInteger(-1);
    ArrayList<Racer> listWinner = new ArrayList<>();
    AtomicLong startTime = new AtomicLong(-1);

    public Race(int distance) {
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    public int getWinner() {
        return winner.get();
    }

    public int getMinSleep() {
		return minSleep;
	}

	public int getMaxSleep() {
		return maxSleep;
	}
}
