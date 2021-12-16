package nextstep.ladder.view;

import nextstep.ladder.domain.Users;

import java.util.Scanner;

/**
 * @author han
 */
public class ResultView {
    private static final String INPUT_USER_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";

    private final Scanner scanner = new Scanner(System.in);

    public Users inputUserNames() {
        System.out.println(INPUT_USER_NAMES);
        String line = scanner.nextLine();
        return Users.createByString(line);
    }

    public Integer inputLadderHeight() {
        System.out.println(INPUT_LADDER_HEIGHT);
        String line = scanner.nextLine();
        return Integer.parseInt(line);
    }
}
