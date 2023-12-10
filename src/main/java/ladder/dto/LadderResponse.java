package ladder.dto;

import ladder.domain.Lines;

public class LadderResponse {
    private final Lines lines;

    public LadderResponse(Lines lines) {
        this.lines = lines;
    }

    public Lines getLines() {
        return lines;
    }
}
