package nextstep.ladder.dto;

import java.util.Collections;
import java.util.List;

public class LadderDto {
    private final List<LineDto> ladder;
    private LadderDto(List<LineDto> ladder) {
        this.ladder = Collections.unmodifiableList(ladder);
    }

    public List<LineDto> getLadder() {
        return ladder;
    }

    public static LadderDto from(List<LineDto> ladder) {
        return new LadderDto(ladder);
    }
}
