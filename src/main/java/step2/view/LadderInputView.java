package step2.view;

import step2.User;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LadderInputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static List<String> getUserNamesWithPrompt(String message) {
        System.out.println(message);

        return Arrays.stream(SCANNER.nextLine().split(","))
                .collect(Collectors.toList());
    }

    public static int getLadderLengthWithPrompt(String message) {
        System.out.println(message);

        return SCANNER.nextInt();
    }
}
