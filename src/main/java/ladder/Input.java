package ladder;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Input {
    private static final String SEPARATOR = ",";
    private static final Scanner sc = new Scanner(System.in);

    static String input() {
        return sc.nextLine();
    }

    public static int integer() {
        String input = input();
        try {
            int i = Integer.parseInt(input);
            checkLeastLadders(i);
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("1이상인 숫자만 입력해주세요");
        }
    }

    private static void checkLeastLadders(int i) {
        if (i < 1) {
            throw new IllegalArgumentException("1이상 입력해주세요");
        }
    }

    public static List<String> players() {
        String input = input();
        return Stream.of(input.split(SEPARATOR)).collect(Collectors.toList());
    }
}
