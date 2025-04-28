package nextstep.ladder.domain.generator;

import nextstep.ladder.domain.ladder.Height;
import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.ladder.Line;

public class LadderGenerator {
    public static Ladder generateLadder(int countOfPerson, Height height) {

        Ladder ladder = new Ladder();
        for (int i = 0; i < height.value(); i++) {
            Line line = new Line(countOfPerson);
            ladder.add(line);
        }

        return ladder;
    }
}
