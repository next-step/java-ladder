package ladder.views;

import java.util.Scanner;

public class InputView {
    private static final String DELIMITER = ",";

    private static final Scanner scanner = new Scanner(System.in);

    public static String[] names() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return scanner.nextLine().split(DELIMITER);
    }

    public static int ladderHeight() {
        System.out.println("\n최대 사다리 높이는 몇 개인가요?");
        final int result = scanner.nextInt();
        clearInputBuffer();
        return result;
    }

    private static void clearInputBuffer() {
        scanner.nextLine();
    }
}
