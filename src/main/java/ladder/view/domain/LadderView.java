package ladder.view.domain;

import ladder.domain.Ladder;
import ladder.domain.Line;

import java.util.stream.Collectors;

public class LadderView implements DomainPrintable<Ladder> {
    private static final String LADDER_STRAIGHT_LINE = "|";
    private static final String LADDER_LINE = "-----";
    private static final String LADDER_EMPTY_LINE = "     ";
    private static final String EMPTY_STRING = "";

    @Override
    public void print(final Ladder ladder) {
        ladder.getLines()
                .stream()
                .map(LadderView::lineUp)
                .forEach(System.out::println);
    }

    private static String lineUp(final Line line) {
        return line.getLine()
                   .stream()
                   .map(stair -> stair.isExist() ? LADDER_LINE : LADDER_EMPTY_LINE)
                   .collect(Collectors.joining(LADDER_STRAIGHT_LINE, EMPTY_STRING, LADDER_STRAIGHT_LINE));
    }
}
