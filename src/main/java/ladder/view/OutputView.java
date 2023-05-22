package ladder.view;

import ladder.domain.HorizontalLine;
import ladder.domain.Ladder;
import ladder.domain.Point;
import ladder.domain.Users;

public class OutputView {

    public static void outputLadder(Users users, Ladder ladder) {
        System.out.printf("%n실행결과%n%n");

        users.forEach(user -> System.out.printf("%6s", user.getName()));
        System.out.println();

        ladder.forEach(OutputView::printLine);
    }

    private static void printLine(HorizontalLine line) {
        line.forEach(OutputView::printPoint);
        System.out.println();
    }

    private static void printPoint(Point point) {
        if (!point.hasLeftLine()) {
            System.out.print("     |");
            return;
        }

        System.out.print("-----|");
    }

}
