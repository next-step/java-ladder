package nextstep.ladder.view;

import java.util.Scanner;

public class InputView {
    private final static String LADDER_GAME_ENTRY_MEMBER_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private final static String LADDER_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private final static Scanner scanner = new Scanner(System.in);

    public InputView() {
    }

    public String inputEntryMember() {
        System.out.println(LADDER_GAME_ENTRY_MEMBER_MESSAGE);
        return scanner.nextLine();
    }

    public int inputLadderHeight() {
        System.out.println(LADDER_HEIGHT_MESSAGE);
        return scanner.nextInt();
    }
}
