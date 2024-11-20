package telran.multithreading;

import java.util.Arrays;

import telran.view.InputOutput;
import telran.view.Item;
import telran.view.Menu;
import telran.view.StandartInputOutput;

public class Main {
    static int numberOfRaces;
    static int distance;
    static Race race;

    public static void main(String[] args) {
        // Runs CLI game's menu with allowing the user to enter number of racers and a
        // distance (number of iterations)
        // Creates Race
        // Runs Racers (Threads)
        // Prints out the Racer-winner number
        Item[] items = {
            Item.of("Enter race's parametres", Main::getRaceParametres),
            Item.of("Start race", Main::startRace),
            Item.ofExit()
        };
        Menu menu = new Menu("Game racer", items);
        menu.perform(new StandartInputOutput());
    }

    static void getRaceParametres(InputOutput io) {
        numberOfRaces = io.readInt("Enter number of racers", "Wrong data");
        distance = io.readInt("Enter distance", "Wrong data");
    }

    static void startRace(InputOutput io) {
        Racer[] racers = new Racer[numberOfRaces];
        race = new Race(distance);
        startThreads(racers);
        waitThreadsFinishing(racers);
        System.out.println("Congratiulation to Racer (" + race.getWinner() + " - winner)");
    }

    private static void startThreads(Racer[] threads) {
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Racer(race, i + 1);
            threads[i].start();
        }
    }

    private static void waitThreadsFinishing(Racer[] threads) {
        Arrays.stream(threads).forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}