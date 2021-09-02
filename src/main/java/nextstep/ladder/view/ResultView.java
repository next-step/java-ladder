package nextstep.ladder.view;

import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.UserName;

import java.util.List;

public class ResultView {

    private static final String START_LADDER = "      |";
    private static final String EXIST_MIDDLE_LADDER = "-----|";
    private static final String EMPTY_MIDDLE_LADDER = "     |";

    public static void result(List<Line> ladder, List<UserName> userNames) {
        printUsers(userNames);
        ladder.stream().forEach((line) -> printLadder(line.getPoints()));
    }

    private static void printLadder(List<Boolean> existPoints) {
        System.out.print(START_LADDER);
        existPoints.stream().forEach(ResultView::printMiddleLadder);
        System.out.println();
    }

    private static void printMiddleLadder(Boolean isExistPoint) {
        if (isExistPoint) {
            System.out.print(EXIST_MIDDLE_LADDER);
            return;
        }
        System.out.print(EMPTY_MIDDLE_LADDER);
    }

    private static void printUsers(List<UserName> userNames) {
        userNames.stream().forEach(userName -> System.out.printf("%6s", userName));
        System.out.println();
    }
}

