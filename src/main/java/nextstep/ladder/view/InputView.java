package nextstep.ladder.view;

import nextstep.ladder.domain.LadderGameUser;
import nextstep.ladder.domain.LadderGameUsers;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InputView {
    private static final String ASK_PARTICIPANTS_NAME_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String ASK_MAXIMUM_LADDER_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String USERNAME_DELIMITER = ",";

    private InputView() {
    }

    public static LadderGameUsers askParticipantsName() {
        System.out.println(ASK_PARTICIPANTS_NAME_MESSAGE);
        String[] inputUserNames = SCANNER.nextLine().split(USERNAME_DELIMITER);
        Map<Integer, LadderGameUser> ladderGameUsers = new HashMap<>();

        for (int i = 0; i < inputUserNames.length; i++) {
            ladderGameUsers.put(i + 1, new LadderGameUser(inputUserNames[i]));
        }

        return new LadderGameUsers(Collections.unmodifiableMap(ladderGameUsers));
    }

    public static int askMaximumLadderHeight() {
        System.out.println(ASK_MAXIMUM_LADDER_HEIGHT_MESSAGE);
        return Integer.parseInt(SCANNER.nextLine());
    }
}

