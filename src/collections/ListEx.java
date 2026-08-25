package collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListEx {
    public static void main(String[] args) {
        //Có đặc điểm truy cập các phần tử theo chỉ mục, có thể thêm các phần tử trùng lặp và duy trì thứ tự chèn

        List<String> arrayList = new ArrayList<>();
        arrayList.add("Kiên");
        arrayList.add("Tuấn");
        arrayList.add("Tùng");
        arrayList.add("Tài");
        arrayList.add("Tiên");
        System.out.println("Danh sách arraylist: " + arrayList);
        System.out.println("Lấy giá trị:" + arrayList.get(1));
        arrayList.set(1, "Ngoc linh");
        arrayList.remove(arrayList.size() - 1);
        System.out.println("Danh sách arraylist sau khi thêm và xoá phần tử cuối : " + arrayList);
        System.out.println("-------------------------------------------------------------");

        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("Kiên");
        linkedList.add("Tuấn");
        linkedList.add("Tùng");
        linkedList.add("Tài");
        linkedList.add("Tiên");
        System.out.println("Danh sách linkedList: " + linkedList);
        System.out.println("Lấy giá trị:" + linkedList.get(1));
        linkedList.set(1, "Ngoc linh");
        linkedList.removeLast();
        System.out.println("Danh sách linkedList sau khi thêm và xoá phần tử cuối : " + linkedList);
    }
}
