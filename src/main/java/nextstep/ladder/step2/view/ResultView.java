package nextstep.ladder.step2.view;

import nextstep.ladder.step2.domain.Ladder;
import nextstep.ladder.step2.domain.Line;
import nextstep.ladder.step2.domain.Name;
import nextstep.ladder.step2.domain.Player;


public class ResultView {
    private static final String EMPTY_LINE = "     |";
    private static final String HORIZONTAL_LINE = "-----|";
    private static final String RESULT_MESSAGE = "실행결과";
    private static final String FORMAT_SIZE = "%6s";

    public static void printLadderGame(Player players, Ladder ladder) {
        System.out.println(RESULT_MESSAGE);
        players.stream().map(ResultView::toFormat).forEach(System.out::print);
        ladder.stream().forEach(ResultView::drawLine);
    }

    private static void drawLine(Line line) {
        System.out.println();
        line.stream()
                .map(point -> isHorizontalLine(point))
                .forEach(System.out::print);
    }

    private static String toFormat(Name name) {
        return String.format(FORMAT_SIZE, name.toString());
    }

    private static String isHorizontalLine(boolean check) {
        if (check) {
            return HORIZONTAL_LINE;
        }
        return EMPTY_LINE;
    }

}
