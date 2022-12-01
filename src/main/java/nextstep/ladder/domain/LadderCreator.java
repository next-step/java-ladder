package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderCreator {

    private LadderCreator() {
    }

    public static Ladder create(final List<String> people, final int height, final List<String> playResults) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(LineCreator.create(people.size()));
        }
        return new Ladder(people, lines, playResults);
    }
}
