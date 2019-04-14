package ladder.view;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_NAMES_MENT = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_RESULT_MENT = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String INPUT_HEIGHT_MENT = "최대 사다리 높이는 몇 개인가요?";
    private static final String FORMAT_ERROR_MENT = "잘못된 포맷입니다.";
    private static final String INPUT_SELECTED_PLAYER_MENT = "결과를 보고 싶은 사람은?";

    public static String inputNames(Scanner scanner) {
        System.out.println(INPUT_NAMES_MENT);
        return scanner.nextLine();
    }

    public static int inputHeight(Scanner scanner) {
        try {
            System.out.println(INPUT_HEIGHT_MENT);
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (Exception e) {
            throw new IllegalArgumentException(FORMAT_ERROR_MENT);
        }
    }

    public static String inputResults(Scanner scanner) {
        System.out.println(INPUT_RESULT_MENT);
        return scanner.nextLine();
    }

    public static String inputSelectedPlayer(Scanner scanner) {
        System.out.println(INPUT_SELECTED_PLAYER_MENT);
        return scanner.nextLine();
    }
}
