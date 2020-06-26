package ladder.view;

import ladder.util.StringUtils;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String INPUT_USER_QUESTION = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    private static final String INPUT_LADDER_RESULTS = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String INPUT_SHOW_LADDER_RESULT = "결과를 보고 싶은 사람은?";
    
    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> inputUser() {
        System.out.println(INPUT_USER_QUESTION);
        String text = scanner.nextLine();

        return StringUtils.split(text, ",");
    }

    public static int inputHeight() {
        System.out.println(INPUT_LADDER_HEIGHT);
        int height = scanner.nextInt();
        scanner.nextLine();
        return height;
    }

    public static List<String> inputLadderResult() {
        System.out.println(INPUT_LADDER_RESULTS);
        String text = scanner.nextLine();

        return StringUtils.split(text, ",");
    }

    public static String inputUserNameToShowLadderResult() {
        System.out.println(INPUT_SHOW_LADDER_RESULT);
        return scanner.nextLine();
    }
}
