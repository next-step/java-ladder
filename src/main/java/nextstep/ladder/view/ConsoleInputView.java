package nextstep.ladder.view;

import java.util.Arrays;
import java.util.Scanner;

public class ConsoleInputView implements InputViewInterface {
    private static final Scanner scanner = new Scanner(System.in);
    public static final String VALID_NUMBER_INPUT_MSG = "유효한 숫자를 입력해 주세요.";

    @Override
    public int getNumberInput(String prompt) {
        System.out.println(prompt);
        String input = scanner.nextLine().trim();
        if (isInteger(input)) {
            return Integer.parseInt(input);
        }
        return getNumberInput(VALID_NUMBER_INPUT_MSG);
    }

    private boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public String getStringInput(String prompt) {
        System.out.println(prompt);
        String input = scanner.nextLine().trim();
        return input.trim();
    }

    @Override
    public String[] getStringListInput(String prompt, String delimiter) {
        System.out.println(prompt);
        String input = scanner.nextLine().trim();
        return Arrays.stream(input.split(delimiter))
                .map(String::trim)
                .toArray(String[]::new);
    }
}
