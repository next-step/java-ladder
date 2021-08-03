package nextstep.ladder.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String INPUT_PLAYER_NAME = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_MAX_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";

    private InputView() {
    }

    public static String getInputPlayerName() {
        System.out.println(INPUT_PLAYER_NAME);
        return scanner.nextLine();
    }

    public static int getInputMaxLadderHeight() {
        System.out.println(INPUT_MAX_LADDER_HEIGHT);
        return scanner.nextInt();
    }
}
