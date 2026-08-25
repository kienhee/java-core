package collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetEx {
    public static void main(String[] args) {
    //    Có đặc điểm là phần tử không được phép trùng nhau
    //    HashSet: không duy trì vị trí sắp xếp
    //    LinkedHashSet: duy trì vị trí tại thời điểm chèn
    //    TreeSet: Tổng hợp các phần tử đã sắp xếp

        Set<String> hashSet = new HashSet<>();
        hashSet.add("Kiên");
        hashSet.add("An");
        hashSet.add("Hoà");
        hashSet.add("Tùng");
        hashSet.add("Tài");
        hashSet.add("Tiên");
        hashSet.add("Khánh");
        hashSet.add("Tài");
        System.out.println("Danh sách hashSet: " + hashSet);
        System.out.println("-------------------------------------------------------------");

        Set<String> linkedHashset = new LinkedHashSet<>();
        linkedHashset.add("Kiên");
        linkedHashset.add("Tuấn");
        linkedHashset.add("An");
        linkedHashset.add("Vương");
        linkedHashset.add("Tài");
        linkedHashset.add("Tiên");
        linkedHashset.add("Tiên");
        linkedHashset.add("Tài");
        linkedHashset.add("Chiến");
        System.out.println("Danh sách linkedHashset: " + linkedHashset);
        System.out.println("-------------------------------------------------------------");

        Set<String> treeSet = new TreeSet<>();
        treeSet.add("Kiên");
        treeSet.add("Đức");
        treeSet.add("Tùng");
        treeSet.add("Bình");
        treeSet.add("Tài");
        treeSet.add("Tiên");
        treeSet.add("Tiên");
        treeSet.add("Tài");
        treeSet.add("Vương");
        System.out.println("Danh sách treeSet: " + treeSet);
        System.out.println("-------------------------------------------------------------");
    }
}
