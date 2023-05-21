package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Point;
import ladder.domain.Users;

public class OutputView {

    public static void outputLadder(Users users, Ladder ladder) {
        System.out.printf("%n실행결과%n%n");

        users.forEach(user -> System.out.printf("%5s ", user.getName()));
        System.out.println();

        ladder.forEach(line -> {
            System.out.print("     |");
            line.forEach(OutputView::printPoint);
            System.out.println();
        });
    }

    private static void printPoint(Point point) {
        if (point.hasRightLine()) {
            System.out.print("     |");
        }
        if (!point.hasRightLine()) {
            System.out.print("-----|");
        }
    }

}
