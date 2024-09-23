package program;

import java.util.concurrent.Exchanger;

public class ThreadMaxMinNum implements Runnable{
    Exchanger<String> arr;

    ThreadMaxMinNum(Exchanger<String> ex) {
        arr = ex;
    }

    @Override
    public void run() {
        try {
            //получить строку из потока
            String str = arr.exchange(null);


            //разделить строку на массив
            String[] stringArray = str.split(" ");


            //массив для int
            int[] intAray = new int[stringArray.length];
            int elementMasive = 0;

            //цикл переводит элемент массива из строки в число и помещяет результат в ячейку массива для числ
            for (int i = 0; i < stringArray.length; i++) {
                int num = Integer.parseInt(stringArray[i]);
                intAray[elementMasive] = num;
                elementMasive++;
            }

            int min = intAray[0];
            int max = intAray[0];

            // цикл определяющий минимальное и максимальное число
            for (int i = 0; i < intAray.length; i++) {
                if (intAray[i] < min) {
                    min = intAray[i];
                }
                if (intAray[i] > max) {
                    max = intAray[i];
                }
            }

            System.out.println("min: " + min);
            System.out.println("max: " + max);

            //результат умножить друг на друга
            int multiply = min * max;
            System.out.println("multiply to update: " + multiply);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
