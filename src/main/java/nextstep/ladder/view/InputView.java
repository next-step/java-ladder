package nextstep.ladder.view;

import nextstep.ladder.domain.Height;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String GET_USER_NAME_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String GET_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String NAME_DELIMITER = ",";

    private InputView() {
    }

    public static List<String> getPlayerNames() {
        System.out.println(GET_USER_NAME_MESSAGE);
        return Arrays.asList(SCANNER.nextLine().split(NAME_DELIMITER));
    }

    public static Height getHeightOfLadder() {
        System.out.println(GET_HEIGHT_MESSAGE);
        return new Height(SCANNER.nextLine());
    }
}
