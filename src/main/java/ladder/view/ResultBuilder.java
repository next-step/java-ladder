package ladder.view;

import ladder.constant.Point;
import ladder.domain.*;
import ladder.exception.NotSupportException;

import java.util.HashMap;
import java.util.Map;

public class ResultBuilder {

    private static final int EMPTY_SIZE = 0;
    private static final int MIN_NAME_PLACE_PER_LENGTH = 6;
    private static final String BLANK_LINE = "\n";
    private static final String VERTICAL_LINE = "|";
    private static final String NAME_EMPTY_ONE_UNIT = " ";
    private static final String NAME_CONNECT_ONE_UNIT = "-";

    private static final StringBuilder sb = new StringBuilder();

    private ResultBuilder() {
        throw new NotSupportException();
    }

    public static String ladderResult(LadderGame ladderGame) {
        Map<Point, String> lineViews = initializeLineViews(ladderGame);
        initializeStringBuilder();

        renderParticipants(ladderGame.playerElements(), maxNameSize(ladderGame));
        renderLadder(ladderGame.ladder(), lineViews);
        renderResultElements(ladderGame.resultElements(), maxNameSize(ladderGame));
        return sb.toString();
    }

    private static Map<Point, String> initializeLineViews(LadderGame ladderGame) {
        Map<Point, String> lines = new HashMap<>();
        lines.put(Point.CONNECTED, drawLine(ladderGame, NAME_CONNECT_ONE_UNIT));
        lines.put(Point.DISCONNECTED, drawLine(ladderGame, NAME_EMPTY_ONE_UNIT));
        return lines;
    }

    private static String drawLine(LadderGame ladderGame, String unit) {
        initializeStringBuilder();
        for (int i = 0; i < maxNameSize(ladderGame); i++) {
            sb.append(unit);
        }
        return sb.toString();
    }

    private static int maxNameSize(LadderGame ladderGame) {
        if (ladderGame.maxNameSize() < MIN_NAME_PLACE_PER_LENGTH) {
            return MIN_NAME_PLACE_PER_LENGTH;
        }
        return ladderGame.maxNameSize();
    }

    private static void renderParticipants(Elements elements, int maxNameSize) {
        for (Element element : elements.toList()) {
            renderElement(element, maxNameSize);
        }
        sb.append(BLANK_LINE);
    }

    private static void renderElement(Element element, int maxNameSize) {
        for (int i = 0; i < element.withoutNameSize(maxNameSize) + 1; i++) {
            sb.append(NAME_EMPTY_ONE_UNIT);
        }
        sb.append(element.name());
    }

    private static void renderLadder(Ladder ladder, Map<Point, String> lineViews) {
        for (Line line : ladder.lines()) {
            renderLine(line, lineViews);
            sb.append(BLANK_LINE);
        }
    }

    private static void renderLine(Line line, Map<Point, String> lineViews) {
        sb.append(lineViews.get(Point.DISCONNECTED));
        for (Point point : line.points()) {
            sb.append(VERTICAL_LINE);
            sb.append(lineViews.get(point));
        }
        sb.append(VERTICAL_LINE);
    }

    private static void initializeStringBuilder() {
        if (sb.length() != EMPTY_SIZE) {
            sb.setLength(EMPTY_SIZE);
        }
    }

    private static void renderResultElements(Elements resultElements, int maxNameSize) {
        for (Element element : resultElements.toList()) {
            renderElement(element, maxNameSize);
        }
        sb.append(BLANK_LINE);
    }
}
