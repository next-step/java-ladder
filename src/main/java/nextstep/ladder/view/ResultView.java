package nextstep.ladder.view;

import nextstep.ladder.model.Ladder;
import nextstep.ladder.model.Line;
import nextstep.ladder.model.Player;
import nextstep.ladder.model.Point;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final int MAX = 7;

    public static void printResultLetters() {
        System.out.println();
        System.out.println("실행결과");
        System.out.println();
    }

    public static void printLadder(Ladder ladder) {
        StringBuilder sb = new StringBuilder();
        List<Line> lines = ladder.getLines();
        lines.forEach(line -> {
            sb.append(" ".repeat(MAX)).append("|");
            List<Boolean> points = line.getPoints().stream().map(Point::getValue).collect(Collectors.toList());
            points.forEach(point -> sb.append(point ? "-".repeat(6) : " ".repeat(6)).append("|"));
            sb.append("\n");
        });
        System.out.println(sb);
    }

    public static void printPlayers(List<Player> players) {
        StringBuilder sb = new StringBuilder();
        players.forEach(player -> sb.append(" ".repeat(getCountOfSpace(player))).append(player.getName()));
        System.out.println(sb);
    }

    private static int getCountOfSpace(Player player) {
        return MAX - player.getName().length();
    }
}
