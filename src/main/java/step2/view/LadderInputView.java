package step2.view;

import step2.User;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LadderInputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static List<String> getParsedStringsWithPrompt(String message, String delimiter) {
        System.out.println(message);

        return Arrays.stream(SCANNER.nextLine().split(delimiter))
                .collect(Collectors.toList());
    }


    public static int getLadderHeightWithPrompt(String message) {
        System.out.println(message);

        return SCANNER.nextInt();
    }
}
