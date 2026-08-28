package compare;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        User user1 = new User(1L, "Kien");
        User user2 = new User(22L, "Tung");
        User user3 = new User(3L, "Ngan");
        User user4 = new User(4L, "Dat");
        User user5 = new User(5L, "Vuong");
        User user6 = new User(50L, "An");

        List<User> list = new java.util.ArrayList<>(List.of(user1, user2, user3, user4, user5, user6));
        Comparator<User> byName = (u1, u2) -> u1.getName().compareTo(u2.getName());
        Collections.sort(list, Comparator.comparing(User::getName));
        System.out.println(list);

    }
}
