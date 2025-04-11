package nextstep.ladder.view;

import java.util.List;
import java.util.stream.Collectors;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Player;

public class OutputView {
    private static final String VERTICAL = "|";
    private static final String BRIDGE = "-----";
    private static final String EMPTY = "     ";


    public static void printPlayers(List<Player> players) {
        System.out.println("실행결과");
        players.forEach(player -> System.out.printf("%6s", player.getValue()));
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


}
