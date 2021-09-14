package Lesson_3_java_Core;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        String[] str = {"aa", "bb", "cc"};
        System.out.println(Arrays.toString(str));
        Exchanger<String> stringExchanger = new Exchanger<>();
        stringExchanger.Exchange(str, 0, 2);
        System.out.println(Arrays.toString(str));

        Box apple_box = new Box(new ArrayList<Apple>());
        Box orange_box = new Box(new ArrayList<Orange>());

        ArrayList<Fruit> fruit_heap = Get_Fruits_List(7);
        System.out.print("Создаём кучу фруктов: ");
        System.out.println(fruit_heap.toString());

        System.out.println("До сортировки в коробке с яблоками: " + apple_box.getList());
        System.out.println("До сортировки в коробке с апельсинами: " + orange_box.getList());

        System.out.println("Сортируем ...");
        List_to_boxes(fruit_heap, apple_box, orange_box);

        System.out.print("После сортировки в коробке с яблоками: ");
        System.out.println(apple_box.getList());
        System.out.print("После сортировки в коробке с апельсинами: ");
        System.out.println(orange_box.getList());

        System.out.println("Вес коробки с яблоками: " + apple_box.getWeight());
        System.out.println("Вес коробки с апельсинами: " + orange_box.getWeight());
        compare(apple_box, orange_box);
    }

    public static ArrayList<Fruit> Get_Fruits_List(int num){
        ArrayList<Fruit> fruit_heap_list = new ArrayList<>();
        for (int i = 0; i < num; i++)
        {
            int x = (int) (Math.random() * 2);
            if (x == 0) {
                fruit_heap_list.add(new Apple());
            }
            else {
                fruit_heap_list.add(new Orange());
            }
        }
        return fruit_heap_list;
    }

    public static void List_to_boxes(ArrayList<Fruit> list, Box box1, Box box2){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) instanceof Apple) {
                box1.getList().add(list.get(i));
            }
            if (list.get(i) instanceof Orange){
                box2.getList().add(list.get(i));
            }
        }
    }

    public static void compare(Box box_a, Box box_o){
        if (box_a.getWeight() > box_o.getWeight()) {
            System.out.println("Коробка с яблоками тяжелее");
        }
        if (box_a.getWeight() < box_o.getWeight()) {
            System.out.println("Коробка с апельсинами тяжелее");
        }
        if (box_a.getWeight() == box_o.getWeight()){
            System.out.println("Коробки одинаково весят");;
        }
    }
}
