package ladder.view;

import java.util.Scanner;

public class InputView {
    private static final String ASK_PARTICIPANT_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String ASK_LADDER_LENGTH = "최대 사다리 높이는 몇 개인가요?";

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

}
