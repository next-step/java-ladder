package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Lines {
    public static final String NEW_LINE = "\n";
    private final List<Line> lines;

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    public Lines(int countOfPerson, int ladderHeight) {
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < ladderHeight; i++) {
            lines.add(new Line(countOfPerson, new RandomCreateStrategy()));
        }

        this.lines = lines;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        this.lines.forEach(l -> stringBuilder.append(l.toString()).append(NEW_LINE));

        return stringBuilder.toString();
    }
}
