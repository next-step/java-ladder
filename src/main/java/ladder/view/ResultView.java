package ladder.view;

import ladder.domain.*;
import ladder.domain.Position;

import java.util.List;

public class ResultView {

    private ResultView() {
        throw new AssertionError();
    }

    public static void printLadder(Players players, Height height) {
        Ladder ladder = Ladder.of(players, height);
        System.out.println("실행결과");
        System.out.println();

        printPlayerName(players);

        List<Line> lines = ladder.getLines();
        for (Line line : lines) {
            List<Point> points = line.getPoints();
            System.out.print("     |");
            for (int i = 1; i < points.size() -1; i++) {
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

    private static void printPlayerName(Players players) {
        List<Player> users = players.getPlayers();
        System.out.printf("%-5s", users.get(0));
        for (int i = 1; i < users.size() - 1; i++) {
            System.out.printf("%6s", users.get(i));
        }
        System.out.printf("%6s%n", users.get(users.size()-1));
    }

}
