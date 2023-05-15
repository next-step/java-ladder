package nextstep.ladder.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LineDto {
    private final List<Boolean> line;
    public LineDto(List<Boolean> line) {
        this.line = new ArrayList<>(line);
    }

    public List<Boolean> getLine() {
        return Collections.unmodifiableList(line);
    }
}
