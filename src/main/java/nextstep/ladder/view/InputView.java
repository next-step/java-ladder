package nextstep.ladder.view;

import java.util.Scanner;

public class InputView {
    private final static String LADDER_GAME_ENTRY_MEMBER_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private final static String LADDER_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private final static String INPUT_ITEMS_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private final static String INPUT_ENTRY_MEMBER_RESULT_ITEM = "결과를 보고 싶은 사람은?";
    private final static Scanner scanner = new Scanner(System.in);

    private InputView() {}

    public static String inputEntryMember() {
        System.out.println(LADDER_GAME_ENTRY_MEMBER_MESSAGE);
        return scanner.nextLine();
    }

    public static int inputLadderHeight() {
        System.out.println(LADDER_HEIGHT_MESSAGE);
        return Integer.parseInt(scanner.nextLine());
    }

    public static String inputItems() {
        System.out.println(INPUT_ITEMS_MESSAGE);
        return scanner.nextLine();
    }

    public static String inputResultName() {
        System.out.println(INPUT_ENTRY_MEMBER_RESULT_ITEM);
        return scanner.nextLine();
    }
}
