package ladder.view;

import java.util.Map;
import ladder.domain.HorizontalLine;
import ladder.domain.Ladder;
import ladder.domain.Point;
import ladder.domain.Results;
import ladder.domain.User;
import ladder.domain.Users;

public class OutputView {

    private static final String ALL = "all";

    public static void outputLadder(Ladder ladder, Users users, Results results) {
        System.out.printf("%n실행결과%n%n");

        users.forEach(user -> System.out.printf("%6s", user.getName()));
        System.out.println();

        ladder.forEach(OutputView::printLine);
        results.forEach(result -> System.out.printf("%6s", result));
        System.out.println();
    }

    public static void outputUsersWithResults(User gameUser, Map<User, String> gameResult) {
        System.out.println("실행 결과");
        if (gameUser.getName().equals(ALL)){
            gameResult.forEach((user, result) -> System.out.printf("%s : %s %n", user.getName(),
                result));
            return;
        }
        System.out.printf("%s : %s", gameUser.getName(), gameResult.get(gameUser));
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
