package nextstep.ladder.view;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Player;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String GET_PLAYER_NAME_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String GET_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String GET_RESULT_NAME_MESSAGE = "결과를 보고 싶은 사람은?";
    private static final String DELIMITER = ",";
    private static final String GET_REWARDS_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";

    private InputView() {
    }

    public static List<String> getPlayerNames() {
        System.out.println(GET_PLAYER_NAME_MESSAGE);
        return Arrays.asList(SCANNER.nextLine().split(DELIMITER));
    }

    public static Height getHeightOfLadder() {
        System.out.println(GET_HEIGHT_MESSAGE);
        return new Height(SCANNER.nextLine());
    }

    public static Player getPlayer() {
        System.out.println(GET_RESULT_NAME_MESSAGE);
        return new Player(SCANNER.nextLine());
    }

    public static List<String> getRewards() {
        System.out.println(GET_REWARDS_MESSAGE);
        return Arrays.asList(SCANNER.nextLine().split(DELIMITER));
    }
}
