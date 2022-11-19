package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderCreator {
    private LineCreator lineCreator;

    public LadderCreator(LineCreator lineCreator) {
        this.lineCreator = lineCreator;
    }

    public Ladder create(int countOfPerson, int height) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(lineCreator.create(countOfPerson));
        }
        return new Ladder(countOfPerson, lines);
    }
}
