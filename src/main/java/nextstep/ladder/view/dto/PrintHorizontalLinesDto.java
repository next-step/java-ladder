package nextstep.ladder.view.dto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import nextstep.ladder.domain.HorizontalLines;

public class PrintHorizontalLinesDto {

    private final List<PrintHorizontalLineDto> lines;

    public PrintHorizontalLinesDto(final HorizontalLines lines) {
        this.lines = lines.getValues().stream()
            .map(PrintHorizontalLineDto::new)
            .collect(Collectors.toList());
    }

    public List<PrintHorizontalLineDto> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
