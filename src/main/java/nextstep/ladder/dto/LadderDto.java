package nextstep.ladder.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LadderDto {
    private final List<LineDto> ladder;
    public LadderDto(List<LineDto> ladder) {
        this.ladder = new ArrayList<>(ladder);
    }

    public List<LineDto> getLadder() {
        return Collections.unmodifiableList(ladder);
    }
}
