package my.project.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created : 2020-12-09 오후 3:53
 * Developer : Seo
 */
public class Lines {
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

        IntStream.range(Interval.FIRST.value(), lineSize).forEach(pointIndex -> {
            if (isNoBridgeBetweenLines(lineIndex, pointIndex)) {
                buildSingleBridge(lineIndex, pointIndex);
                destroySideBridges(lineIndex, pointIndex);
            }
        });
    }

    private boolean isNoBridgeBetweenLines(int lineIndex, int pointIndex) {
        return lineIndex != Interval.FIRST.value()
                && getLine(lineIndex).get(pointIndex) == Symbol.NONE
                && getLine(lineIndex - Interval.LINE.value()).get(pointIndex) == Symbol.NONE;
    }

    private void buildSingleBridge(int lineIndex, int pointIndex) {
        getLine(lineIndex).remove(pointIndex);
        getLine(lineIndex).add(pointIndex, Symbol.BRIDGE);
    }

    private void destroySideBridges(int lineIndex, int pointIndex) {
        if (hasPreviousBridge(pointIndex)) {
            getLine(lineIndex).remove(pointIndex - Interval.BRIDGE.value());
            getLine(lineIndex).add(pointIndex - Interval.BRIDGE.value(), Symbol.NONE);
        }
        if (hasNextBridge(lineIndex, pointIndex)) {
            getLine(lineIndex).remove(pointIndex + Interval.BRIDGE.value());
            getLine(lineIndex).add(pointIndex + Interval.BRIDGE.value(), Symbol.NONE);
        }
    }

    private boolean hasPreviousBridge(int pointIndex) {
        return pointIndex > Interval.VERTICAL.value();
    }

    private boolean hasNextBridge(int lineIndex, int pointIndex) {
        return pointIndex < getSize(lineIndex) - Interval.VERTICAL.value();
    }

    public List<Line> get() {
        return lines;
    }

    public List<Symbol> getLine(int lineIndex) {
        return lines.get(lineIndex).getPoints();
    }

    public int getSize(int lineIndex) {
        return lines.get(lineIndex).getPoints().size();
    }

}
