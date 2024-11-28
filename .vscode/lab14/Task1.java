import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.random.*;
import java.util.stream.Collectors;

public class Task1 {
    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(random.nextInt());
        }
        list.stream().forEach(x -> System.out.print(x + " "));
        System.out.println();
        List<Integer> result = list.stream().filter(x -> x % 3 == 0).collect(Collectors.toList());
        result.stream().forEach(x -> System.out.print(Math.abs(x) + " "));

    }
}
