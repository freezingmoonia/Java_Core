public class Lesson_2_java_core {

    public static void main(String[] args) throws MyArrayDataException {
        String[][] Arr4x4 = {{"1","3","4","2"}, {"3","5","3","2"},
                {"3","2","5","7"}, {"7","3","7","5"}};
        String[][] Arr4x4_not_correct = {{"4","3","dd","2"}, {"5","5","3","2"},
                {"3","2","5","7"}, {"7","3","7","5"}};
        String[][] Arr3x3 = {{"1","3","4"}, {"3","5","3"},
                {"3","2","5"}};

        Check_length(Arr4x4);
        Arr_to_int(Arr4x4);
        Check_length(Arr3x3);
        Arr_to_int(Arr4x4_not_correct);
    }

    public static void Arr_to_int(String Arr[][]) throws MyArrayDataException{

            int sum = 0;
            for (int i = 0; i< Arr.length; i++) {
                for (int j = 0; j < Arr[0].length; j++) {
                    try {
                        sum += Integer.parseInt(Arr[i][j]);
                    } catch (NumberFormatException e) {
                        throw new MyArrayDataException("Не верные данные на "
                                + (i + 1) + " x " + (j + 1));
                    }
                }
            }
            System.out.println(sum);

    }

    public static void Check_length(String Arr[][]) {
        if (Arr.length == 4 && Arr[0].length == 4
                && Arr[1].length == 4
                && Arr[2].length == 4
                && Arr[3].length == 4) {
            System.out.println("Корректный массив 4 на 4");
        }
        else {
            try {
                throw new MyArraySizeException();
                }
            catch (MyArraySizeException e) {
                e.printStackTrace();
            }
        }
    }
}

class MyArrayDataException extends Exception {

    public MyArrayDataException (String message) {
        super(message);
    }
}

class MyArraySizeException extends Exception {
}