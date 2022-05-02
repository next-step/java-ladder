package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.*;

public class Ladders {

    private final List<Line> lines;

    private Ladders(int countOfPlayer, int maxHeight) {
        this.lines = new ArrayList<>();
        for (int i = 0; i < maxHeight; i++) {
            lines.add(new Line(countOfPlayer));
        }
    }

    private Ladders(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladders makeLaddersByPlayersAndHeight(int countOfPlayer, int maxHeight) {
        return new Ladders(countOfPlayer, maxHeight);
    }

    public static Ladders makeDefaultLadders(List<Line> lines) {
        return new Ladders(lines);
    }

    public List<Line> getLines() {
        return unmodifiableList(lines);
    }

    public int findLadderResult(int startPosition) {
        int startColumn = startPosition;

        for (Line line : lines) {
            if (line.canGoRight(startColumn)) {
                startColumn++;
                continue;
            }

            if (line.canGoLeft(startColumn)) {
                startColumn--;
            }
        }
        
        return startColumn;
    }
}
