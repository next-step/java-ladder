package ladder.view;

import ladder.domain.LadderGame;
import ladder.domain.Point;

import java.util.stream.IntStream;

public class OutputView {

    public static void printWinningResult(LadderGame ladderGame) {

        println("실행결과");
        println("==================================");

        ladderGame.players().forEach(player -> System.out.print(player.name() + LadderGame.LADDER_EMPTY_WIDTH));
        System.out.println();
        ladderGame.ladder().forEach(line -> {
            print(LadderGame.PILLAR);
            line.points().forEach(point -> {
                drawLine(point, ladderGame.ladderWidth());
            });
            println("");
        });
    }

    private static void drawLine(Point point, int maxLadderWidth) {
        if(point.isCurrent()) {
            print(drawWidth(maxLadderWidth,LadderGame.LADDER_WIDTH));
            print(LadderGame.PILLAR);
            return;
        }
        print(drawWidth(maxLadderWidth,LadderGame.LADDER_EMPTY_WIDTH));
        print(LadderGame.PILLAR);
    }

    private static String drawWidth(int maxLadderWidth, String widthType) {
        final StringBuilder ladderWidth = new StringBuilder("");

        IntStream.range(0, maxLadderWidth).forEach(count -> {
            String test = "";
            ladderWidth.append(widthType);
        });
        return ladderWidth.toString();
    }

    private static void print(String input) {
        System.out.print(input);
    }

    private static void println(String input) {
        System.out.println(input);
    }
}
