package Java2;

import java.util.Arrays;

public class Main {

    static final int SIZE = 10000000;
    static final int h = SIZE / 2;

    public static void main(String[] args) {

        float[] arr = new float[SIZE];

        /*Первый метод*/
        //заполняем массив единицами
        Arrays.fill(arr, 1.0f);

        long begTime = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Время выполнения первого метода: " + ((System.currentTimeMillis() - begTime) / 1000.0f) + " сек.");

        /*Второй метод*/
        //заполняем массив единицами
        Arrays.fill(arr, 1.0f);

        float[] arr1 = new float[h];
        float[] arr2 = new float[h];

        begTime = System.currentTimeMillis();

        //Делим массив на два
        System.arraycopy(arr, 0, arr1, 0, h);
        System.arraycopy(arr, h, arr2, 0, h);

        Thread thread1 = new Thread(new CalcExpression(arr1, 0));
        Thread thread2 = new Thread(new CalcExpression(arr2, h));

        thread1.start();
        thread2.start();

        //добавляем дочернии потокидля текущего, чтобы точно сначала произвести рассчеты, а только потом слияние массива и вывод результата
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Собираем массив обратно
        System.arraycopy(arr1, 0, arr, 0, h);
        System.arraycopy(arr2, 0, arr, h, h);

        System.out.println("Время выполнения второго метода (двухпоточный): " + ((System.currentTimeMillis() - begTime) / 1000.0f) + " сек.");
    }
}
