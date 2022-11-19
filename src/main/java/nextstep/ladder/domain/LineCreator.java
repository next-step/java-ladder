package nextstep.ladder.domain;

import nextstep.ladder.utils.RandomValueGenerator;

import java.util.ArrayList;
import java.util.List;

public class LineCreator {

    public Line create(final int sizeOfPerson) {
        List<Cross> crosses = new ArrayList<>();
        Cross cross = Cross.first(new RandomValueGenerator().generate());
        crosses.add(cross);

        while(cross.untilBeforeLastPoint(sizeOfPerson)) {
            cross = cross.next(new RandomValueGenerator());
            crosses.add(cross);
        }

        crosses.add(cross.last());
        return new Line(crosses);
    }
}
