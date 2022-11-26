package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderCreator {

    private LadderCreator() {
    }

    public static Ladder create(int countOfPerson, int height) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(LineCreator.create(countOfPerson));
        }
        return new Ladder(countOfPerson, lines);
    }
}
