package Java2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    Map<String, List<String>> phoneBook = new HashMap<>();

    /**
     * Добавляет запись в телефонную книгу. Если контакт не найден, то создаст, иначе добавит номер телефона
     * уже к имеющемуся контакту
     * @param surname Фамилия контакта
     * @param phone Номер телефона
     * */
    public void add (String surname, String phone) {
        //по ключу проверяем наличиии записи в книге, если нет то создаем,
        // иначе добавляем номер телефона в уже имеющуюся запись
        if (phoneBook.get(surname) == null){
            List<String> al = new ArrayList<>();
            phoneBook.put(surname, al);
            phoneBook.get(surname).add(phone);
        }
        else {
            if(!phoneBook.containsValue(phone)) {
                phoneBook.get(surname).add(phone);
            }
        }
    }

    /**
     * Выводит все контакты телефонной книги
     * */
    public void printAll(){
        System.out.println();
        phoneBook.forEach((s, p) -> {
            System.out.println(s + ": " + p);
        });
    }

    /**
     * Возвращает список телефонов по фамилии
     * @param surname Фамилия
     * @return список номеров телефонов
     * */
    public List<String> get(String surname) {
        return phoneBook.get(surname);
    }

}
