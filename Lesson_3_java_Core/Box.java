package Lesson_3_java_Core;

import java.util.ArrayList;

public class Box <T extends Fruit>{

    private Object obj;
    private ArrayList<T> list  = new ArrayList<>();

    public Box(Object obj) {
        this.obj = obj;
    }

    public Box(ArrayList<T> list) {
        this.list = list;
    }

    public ArrayList<T> getList() {
        return list;
    }

    public float getWeight() {
        float weight = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) instanceof Apple) {
                weight += list.get(i).weight;
            }
            else {
                weight += list.get(i).weight;
            }
        }
        return weight;
    }

}
