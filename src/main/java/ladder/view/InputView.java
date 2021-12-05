package ladder.view;

import java.util.*;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String INPUT_NAME_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요";
    private static final String INPUT_HEIGHT_MESSAGE = "최대 사다리 높이는 몇개 인가요?";
    private static final String NULL_ERROR_MESSAGE = "error : null은 사욜할수 없습니다.";
    private static final String EMPTY_ERROR_MESSAGE = "error : 공백은 사용할수 없습니다.";
    private static final String NUMBER_TYPE_ERROR_MESSAGE = "error : 아라비아 숫자만 입력할수 있습니다.";
    private static final String COMMA = ",";

    public static List<String> inputPlayerName() {
        System.out.println(INPUT_NAME_MESSAGE);
        return changeToList(scanner.nextLine());
    }

    public static int inputLadderHeight() {
        System.out.println(INPUT_HEIGHT_MESSAGE);
        return validNumber();
    }

    private static List<String> changeToList(String name) {
        checkNameNull(name);
        checkNameEmpty(name);
        return Arrays.stream(name.split(COMMA))
                .map(String::valueOf)
                .collect(Collectors.toList());
    }

    private static void checkNameNull(String name) {
        if (Objects.isNull(name)) {
            throw new IllegalArgumentException(NULL_ERROR_MESSAGE);
        }
    }

    private static void checkNameEmpty(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_ERROR_MESSAGE);
        }
    }

    private static int validNumber() {
        if (!scanner.hasNext()) {
            throw new IllegalArgumentException(NUMBER_TYPE_ERROR_MESSAGE);
        }

        int number = scanner.nextInt();
        scanner.nextLine();

        return number;
    }
}
