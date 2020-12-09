package ladder.view;

import ladder.domain.ladder.Direction;
import ladder.domain.ladder.Line;
import ladder.domain.ladder.Point;
import ladder.domain.player.Player;
import ladder.domain.player.Players;

import java.util.List;
import java.util.stream.IntStream;

public class ResultView {
    private static final String PRINT_LADDER_WIDTH = "-";
    private static final String PRINT_LADDER_HEIGHT = "|";
    private static final int PRINT_DEFAULT_NAME_SPACE = 5;
    private static final int PRINT_LADDER_REPEAT = 4;

    private ResultView() {

    }

    public static void printUserNames(Players players) {
        players.getPlayers()
                .stream()
                .map(Player::getName)
                .forEach(name -> {
                    System.out.print(repeatWord(" ", PRINT_DEFAULT_NAME_SPACE - name.length()) + name);
                });
        System.out.println();
    }

    public static void printLines(List<Line> lines) {
        lines.forEach(line -> {
            printPoint(line);
            System.out.println();
        });
    }

    public static void printLadderResult(Players players, List<Line> lines) {
        System.out.println("\n실행결과\n");
        printUserNames(players);
        printLines(lines);
    }

    public static void printPoint(Line line) {
        line.getPoints().stream()
                .map(Point::getDirection)
                .map(Direction::isLeft)
                .forEach(aBoolean -> {
                    System.out.print(repeatWord(aBoolean ? PRINT_LADDER_WIDTH : " ", PRINT_LADDER_REPEAT));
                    System.out.print(PRINT_LADDER_HEIGHT);
                });
    }

    private static String repeatWord(String word, int repeat) {
        StringBuilder result = new StringBuilder();
        for ( int i = 0; i < repeat; i++ ) {
            result.append(word);
        }
        return result.toString();
    }
}
