package nextstep.ladder.view;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Name;
import nextstep.ladder.domain.Player;
import nextstep.ladder.domain.Result;

public class OutputView {
    private static final String VERTICAL = "|";
    private static final String BRIDGE = "-----";
    private static final String EMPTY = "     ";

    public static void printPlayers(List<Player> players) {
        System.out.println("사다리 결과");
        players.forEach(player -> System.out.printf("%6s", player.getNameValue()));
        System.out.println();
    }

    public static void printLadder(List<Line> ladder) {
        ladder.forEach(line -> {
            String ladderLine = EMPTY + VERTICAL + line.getPoints().stream()
                    .map(point -> point ? BRIDGE + VERTICAL : EMPTY + VERTICAL)
                    .collect(Collectors.joining());
            System.out.println(ladderLine);
        });
    }

    public static void printResult(List<Result> results) {
        results.forEach(result -> System.out.printf("%6s", result.getValue()));
        System.out.println();
    }

    public static void printPrize(Map<Name, Result> prize) {
        System.out.println("실행 결과");
        prize.forEach((name, result) -> System.out.printf("%s : %s\n", name.getValue(), result.getValue()));
        System.out.println();
    }
}
