package file;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        try {
            File file = new File("D:\\workspace\\tut\\javacore\\src\\file\\test.txt");

            boolean isFile = file.createNewFile();
            if (isFile) {
                System.out.println("File created successfully");
            } else {
                System.out.println("File already exists");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
