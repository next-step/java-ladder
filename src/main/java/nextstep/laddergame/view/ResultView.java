package nextstep.laddergame.view;

import java.util.List;
import java.util.stream.IntStream;

import nextstep.laddergame.model.Line;
import nextstep.laddergame.model.Participant;
import nextstep.laddergame.model.Point;

public final class ResultView {

    private static final StringBuilder stringBuilder = new StringBuilder();

    private static final String VERTICAL = "|";
    private static final String LINE = "-";
    private static final String EMPTY = " ";
    private static final String DELIMITER = "  ";

    private ResultView() {
    }

    public static void printLadder(List<Participant> participants, List<Line> ladder) {
        stringBuilder.setLength(0);
        stringBuilder.append("실행결과\n");
        participants.forEach(participant -> stringBuilder.append(participant.name())
                                                         .append(DELIMITER));
        stringBuilder.append('\n');
        ladder.forEach(line -> printLine(line));

        System.out.println(stringBuilder);
    }

    private static void printLine(Line line) {
        stringBuilder.append(DELIMITER);
        line.getPoints()
            .forEach(point -> printPoint(point));
        stringBuilder.append('|')
                     .append('\n');
    }

    private static StringBuilder printPoint(Point point) {
        stringBuilder.append(VERTICAL);
        String line = point.exist() ? LINE : EMPTY;
        IntStream.range(0, 5)
                 .forEach(index -> stringBuilder.append(line));
        return stringBuilder;
    }
}
