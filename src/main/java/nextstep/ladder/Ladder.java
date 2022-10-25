package nextstep.ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {

    private List<Line> lines = new ArrayList<>();

    public Ladder(int height, int countOfPerson, BooleanGenerator booleanGenerator) {
        IntStream.range(0, height)
                .forEach((i) -> lines.add(new Line(countOfPerson, booleanGenerator)));
    }

    public int executeLaddar(int position) {
        for (int i = lines.size() - 1; i >= 0; i--) {
            Line line = lines.get(i);
            position = line.goOneStep(position);
        }
        return position;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }


}
