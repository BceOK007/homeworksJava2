package Java2;

public interface JumpRunnable {

    /**
     * Метод преодоления беговой дорожки
     * @param distance дистанция, которую необходимо пробежать
     * @return true если необходимая дистанция не больше максимальной дистанции, иначе false
     * */
    boolean run(double distance);

    /**
     * Метод преодоления стены
     * @param height высота, которую необходимо перепрыгнуть
     * @return true если необходимая высота не больше максимальной высоты объекта, иначе false
     * */
    boolean jump(double height);

    /**
     * Метод получения имени объекта
     * @return имя объекта
     * */
    String getName();
}
