package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Names;
import nextstep.ladder.domain.Point;

import java.util.stream.Collectors;

public class ResultView {
    private final static String GAME_RUN_MESSAGE = "실행결과\n";
    private final static String NAME_FORMAT = "%6s";
    private final static String LADDER_BLANK = "     ";
    private final static String LADDER_DASH = "-----";
    private final static String LADDER_LINE = "|";

    public void gameResult(Names names, Ladder ladder) {
        System.out.println(GAME_RUN_MESSAGE);
        System.out.println(printEntryName(names));
        printLaddersResult(ladder);
    }

    private String printEntryName(Names names) {
        return names.getNames()
                .stream()
                .map(name -> String.format(NAME_FORMAT, name.getValue()))
                .collect(Collectors.joining());
    }

    private void printLaddersResult(Ladder ladder) {
        ladder.getLadder().forEach(line -> {
                    line.getLine().forEach(this::printPoint);
                    System.out.println();
                });
    }

    private void printPoint(Point point) {
        if (point.isValue()) {
            System.out.printf("%s%s", LADDER_DASH, LADDER_LINE);
            return;
        }
        System.out.printf("%s%s", LADDER_BLANK, LADDER_LINE);
    }
}
