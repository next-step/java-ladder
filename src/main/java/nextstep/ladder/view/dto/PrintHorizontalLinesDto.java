package nextstep.ladder.view.dto;

import java.util.Collections;
import java.util.List;
import nextstep.ladder.domain.HorizontalLine;
import nextstep.ladder.domain.HorizontalLines;

public class PrintHorizontalLinesDto {

    private final List<HorizontalLine> lines;

    public PrintHorizontalLinesDto(final HorizontalLines lines) {
        this.lines = lines.getValues();
    }

    public List<HorizontalLine> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
