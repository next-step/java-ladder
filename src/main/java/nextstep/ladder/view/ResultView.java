package nextstep.ladder.view;

import nextstep.ladder.model.Ladder;
import nextstep.ladder.model.Line;
import nextstep.ladder.model.Player;

import java.util.List;

public class ResultView {
    private static final int MAX = 7;

    public static void printLadder(Ladder ladder, List<Player> players) {
        System.out.println();
        System.out.println("실행결과");
        System.out.println();

        StringBuilder sb = new StringBuilder();
        players.forEach(player -> sb.append(" ".repeat(getCountOfSpace(player))).append(player.getName()));
        sb.append("\n");

        List<Line> lines = ladder.getLines();
        lines.forEach(line -> {
            sb.append(" ".repeat(MAX)).append("|");
            List<Boolean> points = line.getPoints();
            points.forEach(point -> sb.append(point ? "-".repeat(6) : " ".repeat(6)).append("|"));
            sb.append("\n");
        });
        System.out.println(sb);
    }

    private static int getCountOfSpace(Player player) {
        return MAX - player.getName().length();
    }
}
