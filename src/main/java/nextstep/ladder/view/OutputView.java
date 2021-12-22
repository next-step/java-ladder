package nextstep.ladder.view;

import nextstep.ladder.model.*;

import java.util.stream.Collectors;

public final class OutputView {
    private static final String RESULT_OUTPUT_MESSAGE = "\n실행결과\n";
    private static final String LADDER_HORIZONTAL_BAR = "─";
    private static final String LADDER_VERTICAL_BAR = "┃";
    private static final String BLANK = " ";
    private static final int TEXT_WIDTH = 5;

    private OutputView() {
    }

    public static void printLadderResult(Users users, Ladder ladder) {
        System.out.println(RESULT_OUTPUT_MESSAGE);
        printUserNames(users);
        printLadder(ladder);
    }

    private static void printUserNames(Users users) {
        System.out.println(userNames(users));
    }

    private static String userNames(Users users) {
        return users.getUsers()
                .stream()
                .map(User::getName)
                .map(name -> String.format("%6s", name))
                .collect(Collectors.joining());
    }

    private static void printLadder(Ladder ladder) {
        ladder.getLadders()
                .stream()
                .map(OutputView::ladderLine)
                .forEach(System.out::println);
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
