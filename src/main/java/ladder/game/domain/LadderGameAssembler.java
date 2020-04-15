package ladder.game.domain;

import ladder.game.dto.LadderGameDto;

public class LadderGameAssembler {
    private LadderGameAssembler() {
    }

    public static LadderGameDto assemble(LadderGame ladderGame) {
        return LadderGameDto.of(ladderGame.getLadderGameInfo(), ladderGame.getLadder());
    }
}
