package nextstep.ladder.controller;

import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.dto.LadderGameRequest;
import nextstep.ladder.dto.LadderGameResponse;

public class LadderGameController {

    public LadderGameResponse getGame(LadderGameRequest request) {
        LadderGame ladderGame = LadderGame.of(request.getNames(), request.getHeight());
        return new LadderGameResponse(ladderGame);
    }

}
