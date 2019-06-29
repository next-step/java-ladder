package nextstep.step2.ui;

import nextstep.step2.domain.Ladder;
import nextstep.step2.domain.Line;
import nextstep.step2.domain.Players;
import nextstep.step2.domain.Point;

public class OutputView {
    private static final String VERTICAL_LINE = "|";
    private static final String HORIZONTAL_LINE = "-----";
    private static final String HORIZONTAL_BLANK = "     ";

    public static void printLadderModel(Players players, Ladder ladder) {
        System.out.println("\n실행결과\n");
        players.getPlayers()
               .stream()
               .map(player -> String.format("%-5s", player))
               .forEach(System.out::print);
        System.out.println();

        for (Line line : ladder.getLines()) {
            line.getPoints()
                .stream()
                .map(OutputView::getLadder)
                .forEach(System.out::print);
            System.out.println(VERTICAL_LINE);
        }
    }

    private static String getLadder(Point point) {
        if (point.isPoint()) {
            return VERTICAL_LINE + HORIZONTAL_LINE;
        }

        return VERTICAL_LINE + HORIZONTAL_BLANK;
    }
}
