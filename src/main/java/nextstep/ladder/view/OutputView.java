package nextstep.ladder.view;

import nextstep.ladder.model.*;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class OutputView {
    private static final String RESULT_FOR_LADDER_OUTPUT_MESSAGE = "\n사다리 결과\n";
    private static final String RESULT_FOR_USERS_OUTPUT_MESSAGE = "\n실행 결과";
    private static final String LADDER_HORIZONTAL_BAR = "─";
    private static final String LADDER_VERTICAL_BAR = "┃";
    private static final String BLANK = " ";
    private static final int TEXT_WIDTH = 5;
    private static final String OUTPUT_FORMAT = "%6s";

    private OutputView() {
    }

    public static void printLadderResult(Users users, Ladder ladder, LadderResults ladderResults) {
        System.out.println(RESULT_FOR_LADDER_OUTPUT_MESSAGE);
        System.out.printf("%s%n%s%n%s%n", formattedUserNames(users), formattedLadder(ladder), formattedLadderResults(ladderResults));
    }

    public static void printExecutionResultForUsers(UserResults userResults, String command) {
        System.out.println(RESULT_FOR_USERS_OUTPUT_MESSAGE);
        Stream.of("pobi : 꽝", "honux : 3000", "crong : 꽝", "jk : 5000")
                .forEach(System.out::println);
    }

    private static String formattedUserNames(Users users) {
        return userNames(users);
    }

    private static String formattedLadder(Ladder ladder) {
        return ladder.getLadderLines()
                .stream()
                .map(OutputView::ladderLine)
                .collect(Collectors.joining("\n"));
    }

    private static String formattedLadderResults(LadderResults ladderResults) {
        return ladderResults(ladderResults);
    }

    private static String ladderResults(LadderResults ladderResults) {
        return ladderResults.getLadderResults()
                .stream()
                .map(LadderResult::getValue)
                .map(name -> String.format(OUTPUT_FORMAT, name))
                .collect(Collectors.joining());
    }

    private static String userNames(Users users) {
        return users.getUsers()
                .stream()
                .map(User::getName)
                .map(name -> String.format("%6s", name))
                .collect(Collectors.joining());
    }

    private static String ladderLine(LadderLine ladderLine) {
        return ladderLine.getPoints()
                .stream()
                .map(LadderPoint::getDirection)
                .map(OutputView::ladderPoint)
                .collect(Collectors.joining());
    }

    private static String ladderPoint(PointDirection direction) {
        if (PointDirection.LEFT == direction) {
            return new String(new char[TEXT_WIDTH]).replace("\0", LADDER_HORIZONTAL_BAR) + LADDER_VERTICAL_BAR;
        }
        return new String(new char[TEXT_WIDTH]).replace("\0", BLANK) + LADDER_VERTICAL_BAR;
    }
}
