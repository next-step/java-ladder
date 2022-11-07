package ladder.dto;

import ladder.domain.Ladder;

import java.util.List;
import java.util.stream.Collectors;

public class LadderDto {
    private final List<LineDto> lines;

    public LadderDto(Ladder ladder) {
        this.lines = ladder.lines()
                .stream()
                .map(LineDto::new)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<LineDto> lines() {
        return lines;
    }
}
