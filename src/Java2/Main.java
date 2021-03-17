package Java2;

public class Main {

    public static void main(String[] args) {

        //Массив участников забега
        JumpRunnable[] arrJumpRunnable = {
                new Human("Валера", 150, 1.2),
                new Cat("Мурзик", 100, 1.5),
                new Robot("R2D2", 1000, 3.0)
        };

        //массив препядствий
        Obstacle[] arrObstacles = {
                new Treadmill(100),
                new Wall(1.25),
                new Wall(1.1),
                new Treadmill(200),
                new Wall(1.4),
                new Treadmill(990)
        };

        for (JumpRunnable j : arrJumpRunnable ) {

            System.out.printf("\nНа полосу препядствий выходит %s\n", j.getName());
            boolean isInGame = true;

            for (Obstacle o : arrObstacles) {

                if(isInGame){
                    isInGame = o.overcomingObstacle(j);
                }
                else
                {
                    System.out.printf("%s сошел с полосы препядствий.\n", j.getName());
                    break;
                }
            }

            if(isInGame) System.out.printf("%s прошел всю полосу препядствий!!!\n", j.getName());
        }

        System.out.println("\n\n5.* Задача с перечислениями");
        System.out.println(getWorkingHours(DayOfWeek.Thursday));
    }

    /**
     *Возвращает кол-во оставшихся рабочих часов до конца
     *  недели по заданному текущему дню. Считается, что
     *  текущий день ещё не начался, и рабочие часы за него
     *  должны учитываться.
     *  Если заданный день выходной то вывести "Сегодня выходной"
     * @param day День недели из перечисления
     * @return Сообщение с кол-вом часов до конца рабочей недели
     * */
    public static String getWorkingHours(DayOfWeek day){

        int sumHours = 0;

        if (day.getHour() == 0 ) {
            return "Сегодня выходной";
        }

        for (DayOfWeek d : DayOfWeek.values()){
            if (d.compareTo(day) >= 0) {
                sumHours += d.getHour();
            }
        }

        return "До конца рабочей недели осталось " + sumHours + " ч.";
    }
}
