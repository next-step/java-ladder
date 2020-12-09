package my.project.dto;

import my.project.domain.Ladder;
import my.project.domain.Line;
import my.project.domain.Symbol;

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

    public Lines() {
        lines = new ArrayList<>();
    }

    public void make(Users users, int height) {
        int lineSize = users.getUsers().size();

        for (int i = 0; i < height; i++) {
            add(new Line(lineSize));
        }
    }

    public void balance(int height) {
        for (int i = 0; i < height; i++) {
            arrange(i);
        }
    }

    private void arrange(int i) {
        int lineSize = get(i).getPoints().size();

        IntStream.range(Ladder.FIRST_LINE, lineSize)
                .forEach(j -> {
                    if (isNoBridgeBetweenLines(i, j)) {
                        buildSingleBridge(i, j);
                        destroySideBridges(i, j);
                    }
                });
    }

    private void add(Line line) {
        this.lines.add(line);
    }

    public List<Line> get() {
        return lines;
    }

    public Line get(int y) {
        return this.lines.get(y);
    }

    private void buildSingleBridge(int i, int j) {
        lines.get(i).getPoints().remove(j);
        lines.get(i).getPoints().add(j, Symbol.BRIDGE);
    }

    private void destroySideBridges(int i, int j) {
        if (hasPreviousBridge(j)) {
            lines.get(i).getPoints().remove(j - PREVIOUS_BRIDGE);
            lines.get(i).getPoints().add(j - PREVIOUS_BRIDGE, Symbol.NONE);
        }
        if (hasNextBridge(i, j)) {
            lines.get(i).getPoints().remove(j + LAST_BRIDGE);
            lines.get(i).getPoints().add(j + LAST_BRIDGE, Symbol.NONE);
        }
    }

    private boolean isNoBridgeBetweenLines(int i, int j) {
        return i != Ladder.FIRST_LINE
                && lines.get(i).getPoints().get(j) == Symbol.NONE
                && lines.get(i - PREVIOUS_NUMBER).getPoints().get(j) == Symbol.NONE;
    }

    private boolean hasPreviousBridge(int j) {
        return j > SECOND_VERTICAL;
    }

    private boolean hasNextBridge(int i, int j) {
        return j < lines.get(i).getPoints().size() - LAST_VERTICAL;
    }

}
