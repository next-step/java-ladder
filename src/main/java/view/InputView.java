package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String PARTICIPANT_NAMES_INPUT_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";

    public static String inputParticipantNames() {
        System.out.println(PARTICIPANT_NAMES_INPUT_MESSAGE);
        return scanner.nextLine();
    }
}
