package nextstep.ladder.view.dto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import nextstep.ladder.domain.HorizontalLine;

public class PrintLinesDto {

    private final List<PrintLineDto> lines;

    public PrintLinesDto(final List<HorizontalLine> horizontalLines) {
        this.lines = horizontalLines.stream()
            .map(PrintLineDto::new)
            .collect(Collectors.toList());
    }

    public List<PrintLineDto> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
