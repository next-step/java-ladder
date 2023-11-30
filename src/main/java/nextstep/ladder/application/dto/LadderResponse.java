package nextstep.ladder.application.dto;

import nextstep.ladder.domain.line.Lines;


public class LadderResponse {
    private final Lines lines;

    public LadderResponse(Lines lines) {
        this.lines = lines;
    }

    public Lines getLines() {
        return lines;
    }
}
