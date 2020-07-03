package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {

    private List<Line> ladder = new ArrayList<Line>();

    public Ladder(int height, int userCount) {
        for (int index = 0; index < height; index++) {
            ladder.add(new Line(userCount));
        }
    }

    @Override
    public String toString() {
        return this.ladder.stream()
                .map(Line::toString)
                .collect(Collectors.joining("\n"));
    }
}
