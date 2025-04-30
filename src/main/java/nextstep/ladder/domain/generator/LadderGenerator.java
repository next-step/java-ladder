package nextstep.ladder.domain.generator;

import nextstep.ladder.domain.ladder.Height;
import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.ladder.Line;

public class LadderGenerator {
    public static Ladder generateLadder(int countOfPeople, Height height) {
        Ladder ladder = new Ladder(countOfPeople);
        for (int i = 0; i < height.value(); i++) {
            Line line = new Line(countOfPeople);
            ladder.add(line);
        }

        return ladder;
    }
}
