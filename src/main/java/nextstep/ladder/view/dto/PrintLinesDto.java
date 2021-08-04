package nextstep.ladder.view.dto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import nextstep.ladder.domain.Lines;

public class PrintLinesDto {

    private final List<PrintLineDto> lines;

    public PrintLinesDto(Lines lines) {
        this.lines = lines.getLines().stream()
            .map(PrintLineDto::new)
            .collect(Collectors.toList());
    }

    public List<PrintLineDto> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
