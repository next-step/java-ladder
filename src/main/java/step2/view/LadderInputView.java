package step2.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LadderInputView {
    private static final int USER_NAME_MAX_LENGTH = 5;
    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> getUserNamesWithPrompt(String message) {
        System.out.println(message);

        return Arrays.stream(scanner.nextLine().split(","))
                .peek(LadderInputView::validateUsername)
                .collect(Collectors.toList());
    }

    private static void validateUsername(String n) {
        if (n.length() > USER_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("사람의 이름은 5글자를 넘을 수 없습니다.");
        }
    }

    public static int getLadderLengthWithPrompt(String message) {
        System.out.println(message);
        scanner.nextLine();

        return scanner.nextInt();

    }
}
