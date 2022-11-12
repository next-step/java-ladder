package nextstep.ladder.view.dto;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Names;

public class LadderCreateResultDto {
    private final Names names;
    private final Ladder ladders;

    public LadderCreateResultDto(Names names, Ladder ladders) {
        this.names = names;
        this.ladders = ladders;
    }

    public static LadderCreateResultDto of(Names names, Ladder ladders) {
        return new LadderCreateResultDto(names, ladders);
    }

    public Names getNames() {
        return names;
    }

    public Ladder getLadder() {
        return ladders;
    }
}
