package ladder.view;

import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.Line;
import ladder.domain.ladder.Point;
import ladder.domain.user.Player;
import ladder.domain.user.Players;

import java.util.List;

public class ResultView {

    private ResultView() {
        throw new AssertionError();
    }

    public static void printPlayerName(Players players) {
        System.out.println("실행결과");
        System.out.println();
        List<Player> users = players.getPlayers();
        System.out.printf("%-5s", users.get(0));
        for (int i = 1; i < users.size() - 1; i++) {
            System.out.printf("%6s", users.get(i));
        }
        System.out.printf("%6s%n", users.get(users.size()-1));
    }

    public static void printLadder(Ladder ladder) {

        List<Line> lines = ladder.getLines();
        for (Line line : lines) {
            List<Point> points = line.getPoints();
            System.out.print("     |");
            for (int i = 1; i < points.size(); i++) {
                if (points.get(i).isRight()) {
                    System.out.print("-----|");
                }
                else {
                    System.out.print("     |");
                }
            }
            System.out.println();
        }
    }

}
