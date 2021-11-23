package nextstep.step2.domain;

import nextstep.step2.dto.GameInformation;
import nextstep.step2.vo.Names;

public class LadderGame {

    private final Names names;
    private final Ladder ladder;

    private LadderGame(Names names, Ladder ladder) {
        this.names = names;
        this.ladder = ladder;
    }

    public static LadderGame createWithInfoAndLadder(GameInformation gameInformation, Ladder ladder) {
        return new LadderGame(gameInformation.getNames(), ladder);
    }

    public Ladder getLadder() {
        return ladder;
    }

    public Names getNames() {
        return names;
    }
}
