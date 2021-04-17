package step2.view;

import step2.domain.Line;
import step2.domain.Lines;
import step2.domain.Player;
import step2.domain.Players;

import java.util.stream.IntStream;

public class ResultView {
    public static final String LADDER_MOVE = "|-----";
    public static final String LADDER_STOP = "|     ";

    private ResultView() {
    }

    public static void printLadderStart() {
        System.out.print("\n     ");
    }

    public static void printLadder(Lines lines) {
        lines.getLines().forEach(line -> {
            ResultView.printLadderStart();
            ResultView.printLine(line);
            ResultView.printLadderEnd();
        });
    }

    private static void printLine(Line line) {
        IntStream.range(0, line.getSize())
                .mapToObj(line::getPoint)
                .map(point -> point ? LADDER_MOVE : LADDER_STOP)
                .forEach(System.out::print);
    }

    public static void printLadderEnd() {
        System.out.print("|");
    }

    public static void printPlayer(Players players) {
        players.getPlayers()
                .stream()
                .map(Player::getName)
                .forEach(System.out::print);
    }
}
