package ladder.view;

import ladder.model.Line;
import ladder.util.ViewUtil;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    public static void getResultHeader() {
        System.out.println("실행결과");
    }

    public static String getPoint(boolean value) {
        return value ? "-" : " ";
    }

    public static void showPlayers(String[] players) {
        System.out.println(arrayToString(players));
    }

    private static String arrayToString(String[] players) {
        return Arrays.stream(players)
                .map(ViewUtil::adjustGap)
                .collect(Collectors.joining());
    }

    public static void showLines(List<Line> lines) {
        lines.forEach(line -> System.out.println(line.toString()));
    }
}
