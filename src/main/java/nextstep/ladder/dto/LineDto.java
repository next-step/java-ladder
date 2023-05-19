package nextstep.ladder.dto;

import nextstep.ladder.domain.Line;

import java.util.List;

public class LineDto {
    private final List<Boolean> line;
    private LineDto(List<Boolean> line) {
        this.line = line;
    }

    public List<Boolean> getLine() {
        return line;
    }

    public static LineDto from(Line line) {
        return new LineDto(line.getLine());
    }
}
