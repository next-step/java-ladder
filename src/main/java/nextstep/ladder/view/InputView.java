package nextstep.ladder.view;

import java.util.Scanner;

public class InputView {
    private static final String PARTICIPANT_NAME = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String MAXIMUM_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static String participants() {
        System.out.println(PARTICIPANT_NAME);
        return scanner.nextLine();
    }

    public static Integer ladderHeight() {
        System.out.println(MAXIMUM_LADDER_HEIGHT);
        return Integer.parseInt(scanner.nextLine());
    }
}
