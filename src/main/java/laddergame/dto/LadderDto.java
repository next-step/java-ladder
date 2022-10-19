package laddergame.dto;

import laddergame.domain.Ladder;
import laddergame.domain.LadderLine;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class LadderDto {

    private final List<LadderLineDto> lines;

    public LadderDto(List<LadderLineDto> lines) {
        this.lines = lines;
    }

    public static LadderDto from(Ladder ladder) {
        List<LadderLineDto> lines = new ArrayList<>();
        IntStream.range(0, ladder.getHeight())
                .forEach(indexOfHeight -> {
                    LadderLine line = ladder.getLine(indexOfHeight);
                    lines.add(LadderLineDto.from(line));
                });
        return new LadderDto(lines);
    }

    public List<LadderLineDto> getLines() {
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

    @Override
    public String toString() {
        return "LadderDto{" +
                "lines=" + lines +
                '}';
    }

}
