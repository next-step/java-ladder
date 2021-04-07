package nextstep.ladder.domain;

import nextstep.ladder.view.dto.LadderDto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {

    private final List<Line> lines;

    public Ladder(Height height, int countOfPerson) {
        lines = Stream.generate(()->new Line(countOfPerson))
                .limit(height.value())
                .collect(Collectors.toList());
    }

    public LadderDto readOnlyLadder() {
        return new LadderDto(Collections.unmodifiableList(lines));
    }
}
