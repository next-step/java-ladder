package cc.oakk.ladder.model.ladder.dto;

import cc.oakk.ladder.model.line.dto.LineDto;

import java.util.List;
import java.util.Objects;

public class LadderDto {
    private final List<LineDto> lines;

    public LadderDto(List<LineDto> lines) {
        this.lines = lines;
    }

    public List<LineDto> getLines() {
        return lines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderDto ladderDto = (LadderDto) o;
        return Objects.equals(lines, ladderDto.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }
}
