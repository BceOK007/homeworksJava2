package Java2;

import java.util.*;

public class Main {

    //Массив слов
    private static final String[] WORDS = {"Квадрат", "Треугольник", "Овал", "Ромб", "Трапеция", "Прямоугольник", "Круг"};
    private static Random random = new Random();

    public static void main(String[] args) {

        /*
        *1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
        *  Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
        * Посчитать сколько раз встречается каждое слово.
        * */
        //Заполняем коллекцию 20ю рандомными словами из массива слов
        List<String> al = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            al.add(WORDS[random.nextInt(WORDS.length)]);
        }

        System.out.println("Исходный массив: " + al);

        //Чтобы получить только уникальные значения, помещаем коллекцию в Сет
        Set<String> set = new HashSet<>(al);
        System.out.println("Список уникальных слов: " + set);

        //Слова буду считать при перемещении ArrayList в Map
        Map<String, Integer> map = new HashMap<>();

        for (String s: al){
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        System.out.println("Сколько раз встречались слова: " + map);

        /*
        *2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
        * В этот телефонный справочник с помощью метода add() можно добавлять записи.
        * С помощью метода get() искать номер телефона по фамилии.
        * Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
        * тогда при запросе такой фамилии должны выводиться все телефоны.
        * */

        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Иванов","+7 (905) 750-78-12");
        phoneBook.add("Петров","+7 (905) 505-78-33");
        phoneBook.add("Иванов","+7 (999) 987-78-00");
        phoneBook.add("Новиков","+7 (495) 123-45-67");
        phoneBook.add("Семенов","+7 (495) 541-12-10");

        phoneBook.printAll();

        System.out.printf(phoneBook.get("Петров") == null ? "\nИскомый контакт не найден" : "\nНомера телефонов: " + phoneBook.get("Петров"));

    }
}
