package ladder.view;

import java.util.*;

public class InputView {
    private static final String FORMAT_GUIDE_INPUT_PARTICIPANTS = "\n참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)\n";
    private static final String FORMAT_GUIDE_INPUT_LADDER_HEIGHT = "\n최대 사다리 높이는 몇 개인가요?\n";
    private static final String FORMAT_GUIDE_INPUT_LADDER_PRIZE = "\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)\n";
    private static final String FORMAT_GUIDE_INPUT_PARTICIPANTS_FOR_RESULT = "\n결과를 보고 싶은 사람은?\n";
    private static final String NAME_DELIMITER = ",";
    private static final Scanner SCANNER = new Scanner(System.in);

    public static String[] inputParticipants() {
        System.out.printf(FORMAT_GUIDE_INPUT_PARTICIPANTS);

        return readNames();
    }

    private static String[] readNames() {
        return Arrays.stream(SCANNER.nextLine().split(NAME_DELIMITER))
                .map(String::trim)
                .toArray(String[]::new);
    }

    public static int inputLadderHeight() {
        System.out.printf(FORMAT_GUIDE_INPUT_LADDER_HEIGHT);

        return getInt();
    }

    private static int getInt() {
        return Integer.parseInt(SCANNER.nextLine());
    }

    public static String[] inputLadderPrize() {
        System.out.printf(FORMAT_GUIDE_INPUT_LADDER_PRIZE);

        return readNames();
    }

    public static String inputParticipantsForResult() {
        System.out.printf(FORMAT_GUIDE_INPUT_PARTICIPANTS_FOR_RESULT);

        return SCANNER.nextLine();
    }
}
