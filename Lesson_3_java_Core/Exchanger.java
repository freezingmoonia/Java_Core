package Lesson_3_java_Core;

public class Exchanger<T> {

    public void Exchange(T[] array, int first, int second) {
        T exchanger = array[first];
        array[first] = array[second];
        array[second] = exchanger;
    }
}
