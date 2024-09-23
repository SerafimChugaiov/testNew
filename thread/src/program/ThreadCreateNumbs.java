package program;

import java.util.Random;
import java.util.concurrent.Exchanger;

public class ThreadCreateNumbs implements Runnable {

    Exchanger<String> arr;

    ThreadCreateNumbs(Exchanger<String> ex) {
        arr = ex;
    }

    @Override
    public void run() {
        Random random = new Random();

        int numberOfCells = random.nextInt(15);

        int[] numbs = new int[numberOfCells];
        String str = "";

        for (int i = 0; i < numbs.length; i++){
            numbs[i] = random.nextInt(99);
            System.out.println(numbs[i]);
            str += numbs[i] + " ";
        }
        try {
            arr.exchange(str);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
