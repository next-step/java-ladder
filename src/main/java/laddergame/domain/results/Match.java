package laddergame.domain.results;

import java.util.List;
import laddergame.domain.line.Line;
import laddergame.domain.line.LineStatus;

public class Match implements MatchStrategy{

    private static final int FIRST = 0;

    @Override
    public int getMatchedIndex(int position, List<Line> lines) {
        for (Line line : lines) {
            position = getIndex(position, line.getPoints());
        }
        return position;
    }

    private int getIndex(int position, final List<LineStatus> points) {

        if (isFirst(position)) {
            return connectFirstIndex(position, points);
        }

        if (isMiddle(position, points)) {
            return connectMiddleIndex(position, points);
        }

        return connectLastIndex(position, points);
    }

    private int connectFirstIndex(int position, final List<LineStatus> points) {
        return isRightConnected(position, points) ? ++position : position;
    }

    private int connectMiddleIndex(int position, final List<LineStatus> points) {
        if (isLeftConnected(position, points)) {
            return --position;
        }

        if (isRightConnected(position, points)) {
            return ++position;
        }

        return position;
    }

    private int connectLastIndex(int position, List<LineStatus> points) {
        return isLeftConnected(position, points) ? --position : position;
    }

    private boolean isLeftConnected(final int position, final List<LineStatus> points) {
        return points.get(position - 1) == LineStatus.CONNECTION;
    }

    private boolean isRightConnected(final int position, final List<LineStatus> points) {
        return points.get(position) == LineStatus.CONNECTION;
    }

    private boolean isMiddle(final int position, final List<LineStatus> points) {
        return position != FIRST && points.size() != position;
    }

    private boolean isFirst(final int position) {
        return position == FIRST;
    }
}
