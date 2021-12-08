package ladder.view;

import java.util.*;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String INPUT_NAME_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_PRIZE_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String INPUT_HEIGHT_MESSAGE = "최대 사다리 높이는 몇개 인가요?";
    private static final String PLAYER_RESULT_MESSAGE = "결과를 보고 싶은 사람은?";
    private static final String NULL_ERROR_MESSAGE = "error : null은 사욜할수 없습니다.";
    private static final String EMPTY_ERROR_MESSAGE = "error : 공백은 사용할수 없습니다.";
    private static final String NUMBER_TYPE_ERROR_MESSAGE = "error : 아라비아 숫자만 입력할수 있습니다.";
    private static final String COMMA = ",";
    private static final String NEXT_LINE = "\n";

    public static List<String> inputPlayerName() {
        System.out.println(INPUT_NAME_MESSAGE);
        return changeToList(scanner.nextLine());
    }

    public static List<String> inputPrize(){
        System.out.print(NEXT_LINE);
        System.out.println(INPUT_PRIZE_MESSAGE);
        return changeToList(scanner.nextLine());
    }

    public static int inputLadderHeight() {
        System.out.print(NEXT_LINE);
        System.out.println(INPUT_HEIGHT_MESSAGE);
        return validNumber();
    }

    public static String resultPlayerName(){
        System.out.print(NEXT_LINE);
        System.out.println(PLAYER_RESULT_MESSAGE);
        String text = scanner.nextLine();
        checkText(text);
        return text;
    }

    private static void checkText(String text){
        checkTextNull(text);
        checkTextEmpty(text);
    }

    private static List<String> changeToList(String text) {
        checkText(text);
        return Arrays.stream(text.split(COMMA))
                .map(String::valueOf)
                .collect(Collectors.toList());
    }

    private static void checkTextNull(String name) {
        if (Objects.isNull(name)) {
            throw new IllegalArgumentException(NULL_ERROR_MESSAGE);
        }
    }

    private static void checkTextEmpty(String name) {
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
