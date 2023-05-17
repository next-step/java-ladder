package nextstep.ladder.dto;

import java.util.Collections;
import java.util.List;

public class LineDto {
    private final List<Boolean> line;
    private LineDto(List<Boolean> line) {
        this.line = Collections.unmodifiableList(line);
    }

    public List<Boolean> getLine() {
        return line;
    }

    public static LineDto from(List<Boolean> line) {
        return new LineDto(line);
    }
}
