package Java2;

public class Wall implements Obstacle{

    private double height;

    public Wall(double height) {
        this.height = height;
    }

    @Override
    public boolean overcomingObstacle(JumpRunnable j) {
        return j.jump(height);
    }

}
