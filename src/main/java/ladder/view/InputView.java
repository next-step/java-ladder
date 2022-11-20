package ladder.view;

import ladder.exception.InvalidHeightException;
import ladder.exception.InvalidPositiveException;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String INPUT_NAME_LIST_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    public static final String INPUT_RESULT_LIST_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String INPUT_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String INPUT_RESULT_PLAYER = "결과를 보고 싶은 사람은?";
    private static final String VALIDATE_INTEGER = "양수만 입력할 수 있습니다.";

    private InputView() {
        throw new AssertionError();
    }

    public static List<String> inputNameList() {
        System.out.println(INPUT_NAME_LIST_MESSAGE);
        String inputNameList = SCANNER.nextLine();
        return makeList(inputNameList);
    }

    public static List<String> inputResultList() {
        System.out.println(INPUT_RESULT_LIST_MESSAGE);
        String inputResultList = SCANNER.nextLine();
        return makeList(inputResultList);
    }

    public static Integer inputHeight() {
        System.out.println(INPUT_HEIGHT_MESSAGE);
        String inputHeight = SCANNER.next();
        return convertStringToInt(inputHeight);
    }

    public static String inputResultPlayer() {
        System.out.println(INPUT_RESULT_PLAYER);
        String inputPlayerName = SCANNER.next();
        return inputPlayerName;
    }

    private static List<String> makeList(String inputNameList) {
        String trimmedInputNumberList = inputNameList.replaceAll(" ", "");
        return Arrays.stream(trimmedInputNumberList.split(","))
                .collect(Collectors.toList());
    }

    private static Integer convertStringToInt(String input) {
        try {
            return validatePositive(Integer.parseInt(input));
        } catch (NumberFormatException e) {
            throw new InvalidHeightException(VALIDATE_INTEGER);
        }
    }

    private static Integer validatePositive(Integer parseInt) {
        if (parseInt <= 0) {
            throw new InvalidPositiveException(VALIDATE_INTEGER);
        }
        return parseInt;
    }

}
