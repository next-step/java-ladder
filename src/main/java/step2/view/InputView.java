package step2.view;

import java.util.Scanner;

public class InputView {
    private static final String MESSAGE_NAME_OF_PARTICIPANT = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String MESSAGE_HEIGHT_OF_LADDER = "최대 사다리 높이는 몇 개인가요?";
    private static final String NAME_LENGTH_ERROR_MESSAGE = "이름은 최소 1글자 최대 5글자까지 부여할 수 있습니다.";
    private static final String RESULT_COLUMN_NAME = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String NAME_OF_TARGET = "결과를 보고 싶은 사람은?";

    private static final Scanner sc = new Scanner(System.in);

    public static String requireNameOfParticipant() {
        System.out.println(MESSAGE_NAME_OF_PARTICIPANT);
        return sc.nextLine();
    }

    public static int requireHeightOfLadder() {
        System.out.println(MESSAGE_HEIGHT_OF_LADDER);
        return Integer.parseInt(sc.nextLine());
    }

    public static void printNameLengthErrorMessage() {
        System.out.println(NAME_LENGTH_ERROR_MESSAGE);
    }

    public static String requireResultNames() {
        System.out.println(RESULT_COLUMN_NAME);
        return sc.nextLine();
    }

    public static String requestTarget() {
        System.out.println(NAME_OF_TARGET);
        return sc.nextLine();
    }
}