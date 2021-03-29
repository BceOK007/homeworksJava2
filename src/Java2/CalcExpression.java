package Java2;

public class CalcExpression implements Runnable{
    private final float[] array;
    private final int begElement;

    public CalcExpression(float[] array, int begElement) {
        this.array = array;
        this.begElement = begElement;
    }

    @Override
    public void run() {
        for (int i = 0; i < array.length; i++) {
            array[i] = (float)(array[i] * Math.sin(0.2f + (begElement + i) / 5) * Math.cos(0.2f + (begElement + i) / 5) * Math.cos(0.4f + (begElement + i) / 2));
        }
//        System.out.println("end");
    }
}
