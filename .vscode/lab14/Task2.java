import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.random.*;
import java.util.stream.Collectors;

public class Task2 {
    static Random random = new Random();

    public static void main(String[] args) {
        int range = 10;
        int capacity = 10;
        String regex = "[a-zA-Z]+";
        List<String> stringList = new ArrayList<>();
        for(int i = 0; i<capacity; i++) {
            stringList.add(generateString(Math.abs(random.nextInt(range))));
        }
        for(int i = 0; i<capacity; i++) {
            stringList.add(stringList.get(i));
        }
        stringList.stream().forEach(x -> System.out.print(x + " "));
        System.out.println();
        if(!stringList.isEmpty()) {
            stringList.stream().filter(x -> x.matches(regex)).distinct().collect(Collectors.toList()).forEach(x->System.out.print(x + " "));
        }

    }

    public static String generateString(int length) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            boolean isDigit = random.nextBoolean();
            if (isDigit) {
                stringBuilder.append(random.nextInt(9));
            } else {
                boolean isCapital = random.nextBoolean();
                int code;
                if (isCapital) {
                    code = random.nextInt(26) + 65;
                    stringBuilder.append((char) code);
                } else {
                    code = random.nextInt(26) + 65;
                    stringBuilder.append((char) code);
                }
            }
        }
        return stringBuilder.toString();
    }
}
