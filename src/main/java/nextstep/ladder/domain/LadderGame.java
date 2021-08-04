package nextstep.ladder.domain;

import nextstep.ladder.domain.dto.LadderResult;
import nextstep.ladder.domain.element.Ladder;
import nextstep.ladder.domain.info.LadderGameInfo;
import nextstep.ladder.domain.player.Players;

import java.util.Objects;

public class LadderGame {
    private final GameElement gameElement;
    private final Ladder ladder;

    private LadderGame(LadderGameInfo ladderGameInfo) {
        validate(ladderGameInfo);

        this.gameElement = ladderGameInfo.getGameElement();
        this.ladder = Ladder.create(ladderGameInfo.getLadderInfo());
    }

    private void validate(LadderGameInfo ladderGameInfo) {
        if (Objects.isNull(ladderGameInfo)) {
            throw new IllegalArgumentException("LadderGameInfo는 null이면 안된다");
        }
    }

    public static LadderGame of(LadderGameInfo ladderGameInfo) {
        return new LadderGame(ladderGameInfo);
    }

    public LadderResult result() {
        return LadderResult.of(gameElement, ladder.getFigures());
    }
}
