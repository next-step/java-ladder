package nextstep.laddergame.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {

    private final List<LadderLine> lines = new ArrayList<>();

    public Ladder(int countOfPerson, int height) {
        IntStream.range(0, height)
                 .forEach(index -> lines.add(LadderLine.init(countOfPerson)));
    }

    public List<LadderLine> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public int moveDown(int position) {
        int currentPosition = position;
        for (int i = 0; i < lines.size(); i++) {
            currentPosition = lines.get(i).move(currentPosition);
        }
        return currentPosition;
    }
}
