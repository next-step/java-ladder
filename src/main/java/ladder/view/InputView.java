package ladder.view;

import ladder.domain.Players;
import ladder.domain.LadderResults;

import java.util.Scanner;

public class InputView {

    private static final String PLAYER_INPUT_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(%S)로 구분하세요)\n";
    private static final String LADDER_HEIGHT_INPUT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String RESULT_INPUT_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(%S)로 구분하세요)\n";

    Scanner sc = new Scanner(System.in);

    public String displayIntroUI() {
        System.out.printf(PLAYER_INPUT_MESSAGE, Players.PLAYER_DELIMITER);
        return sc.next();
    }

    public int displayLadderHeightInputUI() {
        System.out.println(LADDER_HEIGHT_INPUT_MESSAGE);
        return sc.nextInt();
    }

    public String displayLadderReulstInputUI() {
        System.out.printf(RESULT_INPUT_MESSAGE, LadderResults.RESULT_DELIMITER);
        return sc.next();
    }

}
