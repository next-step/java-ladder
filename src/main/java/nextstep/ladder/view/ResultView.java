package nextstep.ladder.view;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.ladder.Line;
import nextstep.ladder.domain.ladder.Point;
import nextstep.ladder.domain.player.Player;
import nextstep.ladder.domain.player.Players;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String NEW_LINE = System.lineSeparator();
    private static final String RESULT_MESSAGE = NEW_LINE + "실행결과" + NEW_LINE;

    public static void showLadder(Ladder ladder) {
        System.out.println(RESULT_MESSAGE);

        showPlayers(ladder.players());
        showLines(ladder);
    }

    private static void showLines(Ladder ladder) {
        if (ladder.players().count() == 1) {
            ladder.lines()
                    .forEach(l -> System.out.println("     |"));
            return;
        }

        ladder.lines()
                .forEach(ResultView::showLine);
    }

    private static void showLine(Line line) {
        List<Point> points = line.points();

        Point first = points.get(0);
        System.out.print(first.isEnable() ? "     |-----" : "     |     ");

        for (int i = 1; i < points.size() - 2; i++) {
            if (points.get(i).isEnable()) {
                System.out.print("|-----");
                continue;
            }
            System.out.print("|     ");
        }

        System.out.println("|");
    }

    private static void showPlayers(Players players) {
        List<String> names = players.values()
                .stream()
                .map(Player::name)
                .collect(Collectors.toList());

        names.forEach(name -> System.out.printf("%5s ", name));
        System.out.println();
    }

    private ResultView() {
    }
}
