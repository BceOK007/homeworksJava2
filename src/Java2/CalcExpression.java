package Java2;

import javax.swing.plaf.IconUIResource;

public class CalcExpression implements Runnable{
    private final float[] array;

    public CalcExpression(float[] array) {
        this.array = array;
    }

    @Override
    public void run() {
        for (int i = 0; i < array.length; i++) {
            array[i] = (float)(array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
//        System.out.println("end");
    }
}
