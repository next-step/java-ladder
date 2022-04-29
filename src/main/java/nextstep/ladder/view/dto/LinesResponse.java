package nextstep.ladder.view.dto;

import nextstep.ladder.model.Lines;

import java.util.List;
import java.util.stream.Collectors;

public final class LinesResponse {

    private final List<LineResponse> lines;

    private LinesResponse(List<LineResponse> lines) {
        this.lines = lines;
    }

    public static LinesResponse from(Lines lines) {
        return new LinesResponse(lines.list()
                .stream()
                .map(LineResponse::from)
                .collect(Collectors.toList()));
    }

    public List<LineResponse> getLines() {
        return lines;
    }
}
