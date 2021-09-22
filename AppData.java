import java.io.*;

public class AppData {

    private String[] header = {"aa", "bb", "cc"};
    private int[][] data = {{100, 200, 300}, {111, 222, 333}};

    public String[] getHeader() {
        return header;
    }

    public int[][] getData() {
        return data;
    }

    public static void main(String[] args) {

        AppData data = new AppData();

        //System.out.print(converter(data.getHeader()));     //тест
        //System.out.print(converter(data.getData()));       //тест

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("table.csv"))) {
            writer.write(converter(data.getHeader()) + converter(data.getData()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader reader = new BufferedReader(new FileReader("table.csv"))) {
            String str;
            while ((str = reader.readLine()) != null) {
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String converter (String[]arr){
            String str = "";
            for (int i = 0; i < arr.length; i++) {
                if (i == arr.length - 1) {
                    str += arr[i];
                } else {
                    str += arr[i] + ";";
                }
            }
            str += "\n";
            return str;
        }

    public static String converter ( int[] arr){
        String str = "";
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                str += arr[i];
            } else {
                str += arr[i] + ";";
            }
        }
        return str;
    }

    public static String converter ( int[][] arr){
        String str = "";
        for (int i = 0; i < arr.length; i++) {
            str += converter(arr[i]) + "\n";
        }
        return str;
    }
}
