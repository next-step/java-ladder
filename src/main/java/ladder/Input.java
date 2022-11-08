package ladder;

import java.util.Scanner;

public class Input {
    private static final Scanner sc = new Scanner(System.in);

    static String input() {
        return sc.nextLine();
    }

    public static int integer() {
        String input = sc.nextLine();
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
}
