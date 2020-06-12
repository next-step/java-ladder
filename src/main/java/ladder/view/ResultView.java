package ladder.view;

import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.Line;
import ladder.domain.ladder.Point;
import ladder.domain.player.Players;

import java.util.stream.IntStream;

public class ResultView {

    public static final String COLUMN = "|";
    public static final String BLANK_LINE = "     ";
    public static final String LINE = "-----";

    public void printLadder(Players players, Ladder ladder) {
        System.out.println("\n실행결과\n");
        printPlayer(players);
        printLadder(ladder);
    }

    private void printPlayer(Players players) {
        IntStream.range(0, players.getCountOfPerson())
                .mapToObj(players::get)
                .map(player -> String.format("%6s", player.getName()))
                .forEach(System.out::print);
        System.out.println();
    }

    private void printLadder(Ladder ladder) {
        IntStream.range(0, ladder.height())
                .mapToObj(ladder::get)
                .forEach(this::printLine);
    }

    private void printLine(Line line) {
        System.out.print(BLANK_LINE);
        IntStream.range(0, line.size())
                .mapToObj(line::get)
                .forEach(point -> System.out.print(COLUMN + getLine(point)));
        System.out.println();
    }

    private String getLine(Point point) {
        if (point.hasLine()) {
            return LINE;
        }
        return BLANK_LINE;
    }
}
