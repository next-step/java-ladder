package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.LineRaw;

import java.util.stream.Collectors;

public class OutputView {
    private OutputView() { }

    public static String drawLine(Line line) {
        return line.getPoints()
                .stream()
                .map(LineRaw::getRawByIsDrawn)
                .collect(Collectors.joining("", "|", ""));
    }

    public static void drawLadder(Ladder ladder) {
        String drawnLadder = ladder.getLines()
                .stream()
                .map(OutputView::drawLine)
                .collect(Collectors.joining("\n"));

        System.out.println(drawnLadder);
    }
}
