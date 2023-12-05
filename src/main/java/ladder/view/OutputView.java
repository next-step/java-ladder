package ladder.view;

import ladder.domain.GameResults;
import ladder.domain.Ladder;
import ladder.domain.Members;
import ladder.domain.WinnerResult;
import org.apache.commons.lang3.StringUtils;

public class OutputView {

    private static final String NAME_PADDING_FORMAT = "%6s";
    private static final String INPUT_RESULT_PADDING_FORMAT = "%6s";
    private static final String HORIZONTAL_LINE_FORMAT = "%5s";
    private static final String EMPTY_TEXT_REGAX = "\\s";
    private static final String HORIZONTAL_LINE = "-";
    private static final String VERTICAL_LINE = "|";

    public static void printResultOfLadder(Members members, Ladder ladder, GameResults gameResults) {
        printResultOfLadderTitle();
        printNewLine();
        printNames(members);
        printNewLine();
        printLadder(ladder);
        printInputResults(gameResults);
        printNewLine();
    }

    public static void printResultOfGame(String climber, WinnerResult winnerResult) {
        printNewLine();
        printResultTitle();
        printResult(climber, winnerResult);
        printNewLine();
    }

    private static void printResultOfLadderTitle() {
        System.out.println("사다리 결과");
    }

    private static void printNames(Members members) {
        members.values().forEach(member -> {
            String paddedName = String.format(NAME_PADDING_FORMAT, member.name().toString());
            System.out.print(paddedName);
        });
    }

    private static void printNewLine() {
        System.out.print("\n");
    }

    private static void printLadder(Ladder ladder) {
        String emptyHorizontalLineMark = String.format(HORIZONTAL_LINE_FORMAT, "");
        String horizontalLineMark = String.format(HORIZONTAL_LINE_FORMAT, "")
            .replaceAll(EMPTY_TEXT_REGAX, HORIZONTAL_LINE);

        ladder.horizontalLines().forEach(horizontalLine -> {
            System.out.print(emptyHorizontalLineMark);
            horizontalLine.points().forEach(point -> {
                System.out.print(VERTICAL_LINE);
                if (point.isTrue()) {
                    System.out.print(horizontalLineMark);
                }
                if (point.isFalse()) {
                    System.out.print(emptyHorizontalLineMark);
                }
            });
            System.out.println(VERTICAL_LINE);
        });
    }

    private static void printInputResults(GameResults gameResults) {
        gameResults.values().forEach(inputResult -> {
            String paddedName = String.format(INPUT_RESULT_PADDING_FORMAT, inputResult.toString());
            System.out.print(paddedName);
        });
    }

    private static void printResultTitle() {
        System.out.println("실행결과");
    }

    private static void printResult(String climber, WinnerResult winnerResult) {
        if (StringUtils.equals(climber, "all")) {
            winnerResult.values().forEach((member, gameResult) -> System.out.println(member + ":" + gameResult));
        }
        if (!StringUtils.equals(climber, "all")) {
            System.out.println(winnerResult.gameResult(climber));
        }
    }
}
