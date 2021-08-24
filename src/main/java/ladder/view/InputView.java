package ladder.view;


import ladder.exception.InvalidInputException;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String INPUT_NAME_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String INVALID_BLANK_STRING_MESSAGE = "공백은 입력이 불가합니다.";

    private static String getUserInputValue(String message) {
        System.out.println(message);
        Scanner sc = new Scanner(System.in);
        String inputValue = sc.nextLine();

        checkUserInput(inputValue);

        return inputValue;
    }

    public static List<String> inputNamesOfUsers() {
        return Arrays.asList(getUserInputValue(INPUT_NAME_MESSAGE).split(","));
    }

    public static int inputHeightOfLadder() {
        return Integer.parseInt(getUserInputValue(INPUT_HEIGHT_MESSAGE));
    }

    private static void checkUserInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new InvalidInputException(INVALID_BLANK_STRING_MESSAGE);
        }
    }
}
