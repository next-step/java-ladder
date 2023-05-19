package nextstep.ladder.dto;

import nextstep.ladder.domain.Ladder;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LadderDto {
    private final List<LineDto> ladder;
    private LadderDto(List<LineDto> ladder) {
        this.ladder = Collections.unmodifiableList(ladder);
    }

    public List<LineDto> getLadder() {
        return ladder;
    }

    public static LadderDto from(Ladder ladder) {
        return ladder.getLadder().stream()
                .map(LineDto::from)
                .collect(Collectors.collectingAndThen(Collectors.toUnmodifiableList(), LadderDto::new));
    }
}
