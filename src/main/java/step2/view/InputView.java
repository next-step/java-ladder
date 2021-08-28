package step2.view;

import java.util.Scanner;

public class InputView {
    private static final String MESSAGE_NAME_OF_PARTICIPANT = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String MESSAGE_HEIGHT_OF_LADDER = "최대 사다리 높이는 몇 개인가요?";

    private static final Scanner sc = new Scanner(System.in);

    public String requireNameOfParticipant() {
        System.out.println(MESSAGE_NAME_OF_PARTICIPANT);
        return sc.nextLine();
    }

    public int requireHeightOfLadder() {
        System.out.println(MESSAGE_HEIGHT_OF_LADDER);
        return sc.nextInt();
    }
}
