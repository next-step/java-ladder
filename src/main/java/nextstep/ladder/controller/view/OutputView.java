package nextstep.ladder.controller.view;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.ladder.Line;
import nextstep.ladder.domain.ladder.Participant;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final StringBuffer stringBuffer = new StringBuffer();
    protected static final int STRING_BUFFER_EMPTY_LENGTH = 0;
    private static final String DELIMITER = " ";
    private static final String VERTICAL = "|";
    private static final String HORIZONTAL = "-----";
    private static final String BLANK = "     ";

    private OutputView() {
    }

    public static void showNames(List<Participant> participants) {
        System.out.println(join(participants));
    }

    private static String join(List<Participant> participants) {
        return participants.stream()
                .map(Participant::getName)
                .collect(Collectors.joining(DELIMITER));
    }

    public static void showLadder(Ladder ladder) {
        ladder.lines()
                .forEach(OutputView::showLine);
    }

    private static void showLine(Line line) {
        stringBuffer.append(VERTICAL);
        for (Boolean point : line.points()) {
            showPoint(point);
            stringBuffer.append(VERTICAL);
        }
        flush();
    }

    private static void showPoint(Boolean point) {
        if (point) {
            stringBuffer.append(HORIZONTAL);
            return;
        }
        stringBuffer.append(BLANK);
    }

    private static void flush() {
        System.out.println(stringBuffer);
        stringBuffer.setLength(STRING_BUFFER_EMPTY_LENGTH);
    }

}
