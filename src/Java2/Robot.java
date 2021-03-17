package Java2;

public class Robot implements JumpRunnable{

    private String name;
    private double maxDistance;
    private double maxHeight;

    public Robot(String name, double maxDistance, double maxHeight) {
        this.name = name;
        this.maxDistance = maxDistance;
        this.maxHeight = maxHeight;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public boolean run(double distance) {

        if (maxDistance >= distance){
            System.out.println(name + " пробежал дистанцию " + distance);
        }
        else
        {
            System.out.println(name + " не смог пробежать дистанцию " + distance);
            return false;
        }
        return true;
    }

    @Override
    public boolean jump(double height) {

        if (maxHeight >= height){
            System.out.println(name + " преодолел высоту " + height);
        }
        else
        {
            System.out.println(name + " не смог преодолеть высоту " + height);
            return false;
        }
        return true;
    }
}
