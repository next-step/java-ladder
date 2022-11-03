package ladder.view;

import ladder.exception.InvalidHeightException;
import ladder.exception.InvalidNameException;
import ladder.exception.InvalidPositiveException;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String INPUT_NAME_LIST_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final Integer MAX_NAME_SIZE = 5;
    private static final String VALIDATE_NAME_MESSAGE = "참가자 이름은 5글자를 넘을 수 없습니다.";
    private static final String INPUT_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String VALIDATE_INTEGER = "양수만 입력할 수 있습니다.";

    private InputView() {
        throw new AssertionError();
    }

    public static List<String> InputNameList() {
        System.out.println(INPUT_NAME_LIST_MESSAGE);
        String inputNameList = SCANNER.nextLine().trim();
        return makeNameList(inputNameList).stream()
                .map(InputView::validateName)
                .collect(Collectors.toList());
    }

    public static Integer InputHeight() {
        System.out.println(INPUT_HEIGHT_MESSAGE);
        String inputHeight = SCANNER.next();
        return convertStringToInt(inputHeight);
    }

    private static List<String> makeNameList(String inputNameList) {
        return Arrays.stream(inputNameList.split(",")).collect(Collectors.toList());
    }

    private static String validateName(String name) {
        if (name.length() > MAX_NAME_SIZE) {
            throw new InvalidNameException(VALIDATE_NAME_MESSAGE);
        }
        return name;
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
