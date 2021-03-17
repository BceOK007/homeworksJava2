package Java2;

public interface Obstacle {

    /**
     * Метот преодаления препядствия
     * @param j объект, который будет будет преодолевать препядствие
     * @return true если необходимая высота не больше максимальной высоты объекта, иначе false
     * */
    boolean overcomingObstacle(JumpRunnable j);
}
