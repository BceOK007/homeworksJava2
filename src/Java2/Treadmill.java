package Java2;

public class Treadmill implements Obstacle{

    public double length;

    public Treadmill( double length) {
        this.length = length;
    }

    @Override
    public boolean overcomingObstacle(JumpRunnable j) {
       return j.run(length);
    }
}
