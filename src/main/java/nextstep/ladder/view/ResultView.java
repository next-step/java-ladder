package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Names;
import nextstep.ladder.domain.Point;

import java.util.stream.Collectors;

public class ResultView {
    private final String GAME_RUN_MESSAGE = "실행결과\n";
    private final String NAME_FORMAT = "%6s";
    private final String LADDER_BLANK = "     ";
    private final String LADDER_DASH = "-----";
    private final String LADDER_LINE = "|";

    public void gameResult(Names names, Ladder ladder) {
        System.out.println(GAME_RUN_MESSAGE);

        String entryNames = names.getNames()
                                .stream()
                                .map(name -> String.format(NAME_FORMAT, name.getValue()))
                                .collect(Collectors.joining());
        System.out.println(entryNames);

        ladder.getLadder()
                .forEach(line -> {
                    line.getLine()
                            .forEach(point -> {
                                        System.out.print(printPoint(point));
                                        });
                    System.out.println();
                });
    }

    private String printPoint(Point point) {
        if (point.isValue()) {
            return String.format("%s%s", LADDER_DASH, LADDER_LINE);
        }
        return String.format("%s%s", LADDER_BLANK, LADDER_LINE);
    }
}
