package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.LadderLineGenerator;
import ladder.domain.Participants;

import java.util.*;
import java.util.stream.Collectors;

public class InputView {
    private static final String GUIDE_INPUT_PARTICIPANTS = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String GUIDE_INPUT_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    private static final String NAME_DELIMITER = ",";
    private static final Scanner SCANNER = new Scanner(System.in);

    public static String[] inputParticipants() {
        System.out.println(GUIDE_INPUT_PARTICIPANTS);

        return readNames();
    }

    private static String[] readNames() {
        return Arrays.stream(SCANNER.nextLine().split(NAME_DELIMITER))
                .map(String::trim)
                .toArray(String[]::new);
    }

    public static int inputLadderHeight() {
        System.out.println(GUIDE_INPUT_LADDER_HEIGHT);

        return getInt();
    }

    private static int getInt() {
        return Integer.parseInt(SCANNER.nextLine());
    }
}
