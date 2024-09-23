package program;

import java.util.concurrent.Exchanger;

public class StartingThreads {
    public static void main(String[] args) {
//          ЗАВДАННЯ:
//        У першому потоці необхідно створити генерацію випадкових чисел, а в
//        іншому - пошук максимального та мінімального елементів у цьому масиві
//        і виводити на екран множину цих елементів

        Exchanger<String> exchanger = new Exchanger<>();

        Thread thread1 = new Thread(new ThreadCreateNumbs(exchanger));
        thread1.start();

        Thread thread2 = new Thread(new ThreadMaxMinNum(exchanger));
        thread2.start();
    }
}
