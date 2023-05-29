package ladder.view;

import java.util.Scanner;

public class InputView {

    private static final String INPUT_PLAYERS_NAME_TEXT = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_LADDER_HEIGHT_TEXT = "최대 사다리 높이는 몇 개인가요?";
    private static final String INPUT_LADDER_REWARD_TEXT = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String INPUT_PLAYER_RESULT_VIEW_TEXT = "결과를 보고 싶은 사람은?";
    private Scanner INPUT;

    public InputView(Scanner scanner) {
        this.INPUT = scanner;
    }

    public String inputPlayers() {
        System.out.println(INPUT_PLAYERS_NAME_TEXT);

        return INPUT.nextLine();
    }

    public int inputLadderHeight() {
        System.out.println(INPUT_LADDER_HEIGHT_TEXT);

        return Integer.parseInt(INPUT.nextLine());
    }

    public String inputLadderReward() {
        System.out.println(INPUT_LADDER_REWARD_TEXT);

        return INPUT.nextLine();
    }

    public String inputPlayerName() {
        System.out.println(INPUT_PLAYER_RESULT_VIEW_TEXT);

        return INPUT.nextLine();
    }
}
