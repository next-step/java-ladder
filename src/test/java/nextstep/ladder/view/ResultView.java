package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Members;
import nextstep.ladder.domain.Point;

public class ResultView {

    public static final String VERTICAL_POINT = "     |";
    public static final String VERTICAL_AND_HORIZONTAL_POINT = "-----|";

    public static void print(Members members, Ladder ladder) {
        printMembers(members);
        printLadder(ladder);
    }

    private static void printMembers(Members members) {
        members.forEach(member -> System.out.printf("%6s", member));
        System.out.println();
    }

    public static void printLadder(Ladder ladder) {
        ladder.lines().forEach(ResultView::printLine);
    }

    private static void printLine(Line line) {
        System.out.print(VERTICAL_POINT);
        line.points().forEach(ResultView::printPoint);
        System.out.println();
    }

    private static void printPoint(Point point) {
        if (point.value()) {
            System.out.print(VERTICAL_AND_HORIZONTAL_POINT);
            return;
        }
        System.out.print(VERTICAL_POINT);
    }
}
