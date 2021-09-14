import java.util.*;

public class Phonebook {

    private HashMap<Long, String> phonebook = new HashMap<>();

    public static void main(String[] args) {

        //первая часть ДЗ
        String[] str = {"Orange", "Apple", "Strawberry", "Banana", "Grape",
                "Banana", "Apple", "Banana", "Apple", "Grape"};
        System.out.println("Весь список: " + Arrays.toString(str));
        Set<String> set = new HashSet<>();
        for (int i = 0; i < str.length; i++) {
            set.add(str[i]);
        }
        System.out.println("Cписок только уникальных слов: " + set);
        System.out.println("Cписок дубликатов слов: ");
        for (String i : set) {
            int count = 0;
            for (String j : str) {
                if (i == j) {
                    count++;
                }
            }
            System.out.println(i + ": " + count);
        }

        //вторая часть ДЗ
        Phonebook phonebook = new Phonebook();
        phonebook.add(89773289991l,"Смирнов");
        phonebook.add(89183566725l,"Иванов");
        phonebook.add(89163334126l,"Сидоров");
        phonebook.add(89345688883l,"Иванов");
        phonebook.add(89568656129l,"Смирнов");
        phonebook.add(89183288687l,"Смирнов");

        phonebook.get("Сидоров");
    }

    public Phonebook() {
    }

    public void add( Long number, String surname) {
        this.phonebook.put(number,surname);
    }

    public void get(String surname) {
        System.out.println("Все номера принадлежащие " + surname + " :");
        for (HashMap.Entry<Long, String> i : this.phonebook.entrySet()) {
            if (i.getValue() == surname) {
                System.out.println(i.getKey());
            }
        }
    }
}