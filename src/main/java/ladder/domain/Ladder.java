package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import ladder.domain.request.LadderRequest;

public class Ladder {

    private final List<Line> lines;

    public static Ladder of(LadderRequest request) {
        List<Line> tempLines = new ArrayList<>();
        for (int i = 0; i <= request.getHeight(); i++) {
            tempLines.add(Line.from(request.getWidth(), request.getStrategy()));
        }
        return new Ladder(tempLines);
    }

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public List<Line> getLines() {
        return this.lines;
    }

}
