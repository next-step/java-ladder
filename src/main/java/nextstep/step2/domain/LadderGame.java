package nextstep.step2.domain;

import nextstep.step2.dto.GameInformation;
import nextstep.step2.vo.Names;

public class LadderGame {

    private final GameInformation gameInformation;
    private final Ladder ladder;

    private LadderGame(GameInformation gameInformation, Ladder ladder) {
        this.gameInformation = gameInformation;
        this.ladder = ladder;
    }


    public static LadderGame createWithInfoAndLadder(GameInformation gameInformation, Ladder ladder) {
        return new LadderGame(gameInformation, ladder);
    }

    public Ladder getLadder() {
        return ladder;
    }

    public Names getNames() {
        return gameInformation.getNames();
    }
}
