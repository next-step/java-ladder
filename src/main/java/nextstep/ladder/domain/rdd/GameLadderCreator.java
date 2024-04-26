package nextstep.ladder.domain.rdd;

import nextstep.ladder.interfaces.Ladder;
import nextstep.ladder.interfaces.LadderCreator;
import nextstep.ladder.interfaces.Line;
import nextstep.ladder.interfaces.LineCreator;

import java.util.ArrayList;
import java.util.List;

public class GameLadderCreator implements LadderCreator {
    private final LineCreator lineCreator;

    public GameLadderCreator(LineCreator lineCreator) {
        this.lineCreator = lineCreator;
    }

    @Override
    public Ladder create(int height, int countOfPeople) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(lineCreator.create(countOfPeople));
        }
        return new GameLadder(countOfPeople, lines);
    }
}
