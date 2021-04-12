package nextstep.ladder.view.dto;

import nextstep.ladder.domain.Line;

import java.util.Collections;
import java.util.List;

public class LadderDto {

    private List<Line> lines;

    public LadderDto(List<Line> lines) {
        this.lines = lines;
    }

    public List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }
}
