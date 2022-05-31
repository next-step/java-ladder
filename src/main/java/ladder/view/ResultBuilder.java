package ladder.view;

import ladder.domain.*;
import ladder.exception.NotSupportException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultBuilder {

    private static final int EMPTY_SIZE = 0;
    private static final int MIN_NAME_PLACE_PER_LENGTH = 6;
    private static final int SINGLE_RESULT_INDEX = 0;
    private static final int SINGLE_RESULT_SIZE = 1;
    private static final String BLANK_LINE = "\n";
    private static final String VERTICAL_LINE = "|";
    private static final String NAME_EMPTY_ONE_UNIT = " ";
    private static final String NAME_CONNECT_ONE_UNIT = "-";
    private static final String ALL_RESULT_TEMPLATE = "%s : %s";

    private static final StringBuilder sb = new StringBuilder();

    private ResultBuilder() {
        throw new NotSupportException();
    }

    public static String ladderResult(Ladder ladder) {
        Map<Boolean, String> lineViews = initializeLineViews(ladder);
        initializeStringBuilder();

        renderPositions(ladder.playerPositions(), maxNameSize(ladder));
        renderLadder(ladder, lineViews);
        renderPositions(ladder.resultPositions(), maxNameSize(ladder));
        return sb.toString();
    }

    private static Map<Boolean, String> initializeLineViews(Ladder ladder) {
        Map<Boolean, String> lines = new HashMap<>();
        lines.put(Point.CONNECTED, drawLine(ladder, NAME_CONNECT_ONE_UNIT));
        lines.put(Point.DISCONNECTED, drawLine(ladder, NAME_EMPTY_ONE_UNIT));
        return lines;
    }

    private static String drawLine(Ladder ladder, String unit) {
        initializeStringBuilder();
        for (int i = 0; i < maxNameSize(ladder); i++) {
            sb.append(unit);
        }
        return sb.toString();
    }

    private static int maxNameSize(Ladder ladder) {
        if (ladder.maxNameSize() < MIN_NAME_PLACE_PER_LENGTH) {
            return MIN_NAME_PLACE_PER_LENGTH;
        }
        return ladder.maxNameSize();
    }

    private static void renderPositions(Positions positions, int maxNameSize) {
        for (Position position : positions.toList()) {
            renderPosition(position, maxNameSize);
        }
        sb.append(BLANK_LINE);
    }

    private static void renderPosition(Position position, int maxNameSize) {
        for (int i = 0; i < position.withoutNameSize(maxNameSize) + 1; i++) {
            sb.append(NAME_EMPTY_ONE_UNIT);
        }
        sb.append(position.name());
    }

    private static void renderLadder(Ladder ladder, Map<Boolean, String> lineViews) {
        for (Line line : ladder.lines()) {
            renderLine(line, lineViews);
            sb.append(BLANK_LINE);
        }
    }

    private static void renderLine(Line line, Map<Boolean, String> lineViews) {
        for (Point point : line.points()) {
            sb.append(lineViews.get(point.isLeftConnected()));
            sb.append(VERTICAL_LINE);
        }
    }

    private static void initializeStringBuilder() {
        if (sb.length() != EMPTY_SIZE) {
            sb.setLength(EMPTY_SIZE);
        }
    }

    public static String searchResult(List<Result> results) {
        initializeStringBuilder();

        if (results.size() == SINGLE_RESULT_SIZE) {
            return renderSingleResult(results.get(SINGLE_RESULT_INDEX));
        }
        return renderMultiResult(results);
    }

    private static String renderSingleResult(Result result) {
        sb.append(result.value());
        return sb.toString();
    }

    private static String renderMultiResult(List<Result> results) {
        for (Result result : results) {
            sb.append(String.format(ALL_RESULT_TEMPLATE, result.playerName(), result.value()));
            sb.append(BLANK_LINE);
        }
        return sb.toString();
    }
}
