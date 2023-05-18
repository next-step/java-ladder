package ladder.view;

import ladder.model.Line;
import ladder.model.Players;
import ladder.model.Result;
import ladder.util.ViewUtil;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    public static void showResultHeader() {
        System.out.println("사다리 결과");
    }

    public static void showPlayerResult(String value){
        System.out.println("실행 결과");
        System.out.println(value);
    }

    public static void showContentsCarriageReturn(String result) {
        System.out.println(result);
    }

    public static void showContentsNoCarriageReturn(String result) {
        System.out.print(result);
    }

    public static void showPlayers(Players players) {
        showContentsCarriageReturn(arrayToString(players));
    }

    private static String arrayToString(Players players) {
        return players.getPlayers().stream()
                .map(player -> ViewUtil.adjustGap(player.getName()))
                .collect(Collectors.joining());
    }

    public static void showLines(List<Line> lines) {
        lines.forEach(line -> showContentsCarriageReturn(line.toString()));
    }

    public static void showResults(List<Result> results) {
        showContentsCarriageReturn(results.stream()
                .map(result->ViewUtil.adjustGap(result.value()))
                .collect(Collectors.joining()));
//        results.forEach(result -> showContentsNoCarriageReturn(result.value()));
    }
}
