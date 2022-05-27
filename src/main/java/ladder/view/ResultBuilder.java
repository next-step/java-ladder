package ladder.view;

import ladder.constant.Point;
import ladder.domain.*;
import ladder.exception.NotSupportException;

public class ResultBuilder {

    private static final int EMPTY_SIZE = 0;
    private static final int NAME_PLACE_PER_LENGTH = 6;
    private static final String BLANK_LINE = "\n";
    private static final String INITIAL_EMPTY_SPACE = "     ";
    private static final String VERTICAL_LINE = "|";
    private static final String HORIZONTAL_CONNECTED_LINE = "-----";
    private static final String HORIZONTAL_DISCONNECTED_LINE = "     ";
    private static final String NAME_EMPTY_ONE_UNIT = " ";

    private static final StringBuilder sb = new StringBuilder();

    private ResultBuilder() {
        throw new NotSupportException();
    }

    public static String ladderResult(LadderGame ladderGame) {
        initializeStringBuilder();

        renderParticipants(ladderGame.people());
        renderLadder(ladderGame.ladder());
        return sb.toString();
    }

    private static void renderParticipants(People people) {
        for (Element element : people.toList()) {
            renderPerson(element);
        }
        sb.append(BLANK_LINE);
    }

    private static void renderPerson(Element element) {
        for (int i = 0; i < element.withoutNameSize(NAME_PLACE_PER_LENGTH); i++) {
            sb.append(NAME_EMPTY_ONE_UNIT);
        }
        sb.append(element.name());
    }

    private static void renderLadder(Ladder ladder) {
        for (Line line : ladder.lines()) {
            renderLine(line);
            sb.append(BLANK_LINE);
        }
    }

    private static void renderLine(Line line) {
        sb.append(INITIAL_EMPTY_SPACE);
        for (Point point : line.points()) {
            sb.append(VERTICAL_LINE);
            renderPoint(point);
        }
        sb.append(VERTICAL_LINE);
    }

    private static void renderPoint(Point point) {
        if (point.isConnect()) {
            sb.append(HORIZONTAL_CONNECTED_LINE);
            return;
        }
        sb.append(HORIZONTAL_DISCONNECTED_LINE);
    }

    private static void initializeStringBuilder() {
        if (sb.length() != EMPTY_SIZE) {
            sb.setLength(EMPTY_SIZE);
        }
    }
}
