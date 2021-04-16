package step2.view;

import step2.domain.Line;
import step2.domain.Player;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {
    public static final String LADDER_MOVE = "|-----";
    public static final String LADDER_STOP = "|     ";

    private ResultView() {
    }

    public static void printLadderStart() {
        System.out.print("\n     ");
    }

    public static void printLadder(Line line) {
        IntStream.range(0, line.getSize())
                .mapToObj(line::getPoint)
                .map(point -> point ? LADDER_MOVE : LADDER_STOP)
                .forEach(System.out::print);
    }

    public static void printLadderEnd() {
        System.out.print("|");
    }

    public static void printPlayer(List<Player> players) {
        players.stream()
                .map(Player::getName)
                .forEach(System.out::print);
    }
}
