package nextstep.ladder.dto;

import nextstep.ladder.domain.LadderGame;

public class LadderGameResponse {

    private final LadderGame ladderGame;

    public LadderGameResponse(LadderGame ladderGame) {
        this.ladderGame = ladderGame;
    }

    public LadderGame getLadderGame() {
        return ladderGame;
    }

}
