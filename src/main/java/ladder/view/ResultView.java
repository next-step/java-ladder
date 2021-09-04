package ladder.view;

import java.util.List;
import ladder.domain.ladder.Line;
import ladder.domain.ladder.Point;
import ladder.domain.user.User;

public class ResultView {

    private ResultView() {
    }

    public static void printUsers(List<User> users) {
        for (User user : users) {
            System.out.printf("%6s", user.nameToString());
        }
        System.out.println();
    }

    public static void printLadder(List<Line> ladder) {
        for (Line line : ladder) {
            System.out.print("     ");
            for (Point point : line.value()) {
                if (point.isConnected()) {
                    System.out.printf("|-----");
                } else {
                    System.out.printf("|     ");
                }
            }
            System.out.println();
        }
    }

}
