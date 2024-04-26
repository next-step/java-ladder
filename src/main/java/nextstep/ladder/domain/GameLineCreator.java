package nextstep.ladder.domain;

import nextstep.ladder.interfaces.Line;
import nextstep.ladder.interfaces.LineCreator;

import java.util.ArrayList;
import java.util.List;

public class GameLineCreator implements LineCreator {
    @Override
    public Line create(int countOfPeople) {
        List<Rung> rungs = new ArrayList<>();
        Rung rung = Rung.first(RandomRungGenerator.generate());
        rungs.add(rung);

        while (rung.isInLadderRange(countOfPeople)) {
            rung = rung.next();
            rungs.add(rung);
        }

        rungs.add(rung.last());

        return new GameLine(rungs);
    }
}
