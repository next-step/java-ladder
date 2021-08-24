package nextstep.ladder.domain;

import nextstep.ladder.dto.LadderBarStatusDto;

import java.util.List;
import java.util.stream.Collectors;

public class Ladder {

    private final List<Line> lines;

    public Ladder(final Players players, final Height height) {
        this.lines = height.intStream()
                .mapToObj(i -> new Line(players.count()))
                .collect(Collectors.toList());
    }

    public LadderBarStatusDto getLadderBarStatus() {
        return new LadderBarStatusDto(lines.stream()
                .map(Line::getLineBarStatus)
                .collect(Collectors.toList()));
    }

}
