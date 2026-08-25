package collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapEx {
    public static void main(String[] args) {
        // Đặc điểm lưu trữ dữ liệu theo cặp key-value pair, key là duy nhất
    //    HashMap: Không theo thứ tự
    //    LinkedHashMap: theo thứ tự chèn
    //    TreeMap: tổng hợp phần tử đã sắp xếp theo key

        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("bun", 10000);
        hashMap.put("pho", 15000);
        hashMap.put("com", 100000);
        hashMap.put("mi cay", 13000);
        hashMap.put("bun bo hue", 120000);
        hashMap.put("bun hai san", 110000);
        System.out.println(hashMap);
        System.out.println("---------------------------------------------------");

        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("bun", 10000);
        linkedHashMap.put("pho", 15000);
        linkedHashMap.put("com", 100000);
        linkedHashMap.put("mi cay", 13000);
        linkedHashMap.put("bun bo hue", 120000);
        linkedHashMap.put("bun hai san", 110000);
        System.out.println(linkedHashMap);
        System.out.println("---------------------------------------------------");

        Map<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("bun", 10000);
        treeMap.put("pho", 15000);
        treeMap.put("com", 100000);
        treeMap.put("mi cay", 13000);
        treeMap.put("bun bo hue", 120000);
        treeMap.put("bun hai san", 110000);
        System.out.println(treeMap);
        System.out.println("---------------------------------------------------");
    }
}
