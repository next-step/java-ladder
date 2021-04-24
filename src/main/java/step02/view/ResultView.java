package step02.view;

import step02.dto.LadderGameDTO;
import step02.ladder.Ladder;
import step02.ladder.Line;
import step02.user.Name;
import step02.user.Users;

public class ResultView {
    private final static String RESULT_TITLE = "실행결과";
    private final static String RESULT_LADDER_HAS_LINE = "-----";
    private final static String RESULT_LADDER_HAS_NO_LINE = "     ";
    private final static String RESULT_LINE = "|";

    private static final int MAX_LENGTH_NAME = 5;
    private static final String BLANK = " ";
    private static final String BRAKE_LINE = "\n";


    private ResultView() {
    }

    public static void showLadderResult(LadderGameDTO ladderGameDTO) {
        showResultTitle();
        showUserNames(ladderGameDTO.getUsers());
        showLadder(ladderGameDTO.getLadder());
    }

    private static void showResultTitle() {
        System.out.println(RESULT_TITLE);
    }

    private static void showUserNames(Users users) {
        for (Name name : users.getUserNames()) {
            System.out.print(showNameWithBlank(name));
        }
        System.out.print(BRAKE_LINE);
    }

    private static String showNameWithBlank(Name name) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i <= MAX_LENGTH_NAME - name.getNameLength(); i++) {
            builder.append(BLANK);
        }
        return builder.append(name.getName()).toString();
    }

    public static void showLadder(Ladder ladder) {
        ladder.getLadderLine().forEach(line -> {
            System.out.print(RESULT_LADDER_HAS_NO_LINE);
            for (int x = 0; x < ladder.getXLineCount(); x++) {
                checkShowLadder(line, x);
            }
            System.out.print(BRAKE_LINE);
        });
    }

    private static void checkShowLadder(Line line, int yPoint) {
        if (line.isHasLine(yPoint)) {
            System.out.print(RESULT_LINE + RESULT_LADDER_HAS_LINE);
        } else {
            System.out.print(RESULT_LINE + RESULT_LADDER_HAS_NO_LINE);
        }
    }
}
