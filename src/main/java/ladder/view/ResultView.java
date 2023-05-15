package ladder.view;

import ladder.model.Line;
import ladder.model.Player;
import ladder.model.Players;
import ladder.util.ViewUtil;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    public static void showResultHeader() {
        System.out.println("실행결과");
    }

    public static void showContents(String result) {
        System.out.println(result);
    }

    public static void showPlayers(Players players) {
        showContents(arrayToString(players));
    }

    private static String arrayToString(Players players) {
        return players.getPlayers().stream()
                .map(player -> ViewUtil.adjustGap(player.getName()))
                .collect(Collectors.joining());
    }

    public static void showLines(List<Line> lines) {
        lines.forEach(line -> showContents(line.toString()));
    }
}
