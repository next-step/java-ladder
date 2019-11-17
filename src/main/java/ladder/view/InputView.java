package ladder.view;

import java.util.Scanner;

public class InputView {
    private static final String ASK_PARTICIPANT_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String ASK_LADDER_LENGTH = "최대 사다리 높이는 몇 개인가요?";
    private static final String ASK_RESULT_SET = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String ASK_RESULT_PARTICIPANTS = "결과를 보고 싶은 사람은?";
    private static Scanner scanner = new Scanner(System.in);

    public static String inputParticipant() {
        System.out.println(ASK_PARTICIPANT_NAMES);
        return scanner.nextLine();
    }

    public static int inputHeight() {
        System.out.println();
        System.out.println(ASK_LADDER_LENGTH);
        return scanner.nextInt();
    }

    public static String inputResults() {
        scanner.nextLine();
        System.out.println(ASK_RESULT_SET);
        return scanner.nextLine();
    }

    public static String inputParticipantForResult() {
        System.out.println(ASK_RESULT_PARTICIPANTS);
        return scanner.nextLine();
    }
}
