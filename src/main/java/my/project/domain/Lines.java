package my.project.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created : 2020-12-09 오후 3:53
 * Developer : Seo
 */
public class Lines {
    public static final int SECOND_VERTICAL = 2;
    public static final int PREVIOUS_NUMBER = 1;
    public static final int PREVIOUS_BRIDGE = 2;
    public static final int LAST_VERTICAL = 2;
    public static final int LAST_BRIDGE = 2;

    private final List<Line> lines;

    public Lines(Users users, int height) {
        lines = new ArrayList<>();
        int countOfPerson = users.getUsers().size();

        for (int lineIndex = 0; lineIndex < height; lineIndex++) {
            lines.add(new Line(countOfPerson));
        }

        balancing(height);
    }

    private void balancing(int height) {
        for (int lineIndex = 0; lineIndex < height; lineIndex++) {
            arrangeLine(lineIndex);
        }
    }

    private void arrangeLine(int lineIndex) {
        int lineSize = getSize(lineIndex);

        IntStream.range(Ladder.FIRST_LINE, lineSize).forEach(pointIndex -> {
            if (isNoBridgeBetweenLines(lineIndex, pointIndex)) {
                buildSingleBridge(lineIndex, pointIndex);
                destroySideBridges(lineIndex, pointIndex);
            }
        });
    }

    private boolean isNoBridgeBetweenLines(int lineIndex, int pointIndex) {
        return lineIndex != Ladder.FIRST_LINE
                && getLine(lineIndex).get(pointIndex) == Symbol.NONE
                && getLine(lineIndex - PREVIOUS_NUMBER).get(pointIndex) == Symbol.NONE;
    }

    private void buildSingleBridge(int lineIndex, int pointIndex) {
        getLine(lineIndex).remove(pointIndex);
        getLine(lineIndex).add(pointIndex, Symbol.BRIDGE);
    }

    private void destroySideBridges(int lineIndex, int pointIndex) {
        if (hasPreviousBridge(pointIndex)) {
            getLine(lineIndex).remove(pointIndex - PREVIOUS_BRIDGE);
            getLine(lineIndex).add(pointIndex - PREVIOUS_BRIDGE, Symbol.NONE);
        }
        if (hasNextBridge(lineIndex, pointIndex)) {
            getLine(lineIndex).remove(pointIndex + LAST_BRIDGE);
            getLine(lineIndex).add(pointIndex + LAST_BRIDGE, Symbol.NONE);
        }
    }

    private boolean hasPreviousBridge(int pointIndex) {
        return pointIndex > SECOND_VERTICAL;
    }

    private boolean hasNextBridge(int lineIndex, int pointIndex) {
        return pointIndex < getSize(lineIndex) - LAST_VERTICAL;
    }

    public int getSize(int lineIndex) {
        return lines.get(lineIndex).getPoints().size();
    }

    private List<Symbol> getLine(int lineIndex) {
        return lines.get(lineIndex).getPoints();
    }

    public List<Line> get() {
        return lines;
    }

    public Line get(int y) {
        return this.lines.get(y);
    }

}
