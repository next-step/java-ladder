package nextstep.step2.domain;

import nextstep.step2.dto.LadderInformation;
import nextstep.step2.vo.BooleanGenerateStrategy;
import nextstep.step2.vo.Names;

public class LadderGame {

    private final Ladder ladder;
    private final Names names;

    private LadderGame(Ladder ladder, Names names) {
        this.ladder = ladder;
        this.names = names;
    }

    public static LadderGame createWithLadderInformation(LadderInformation ladderInformation, BooleanGenerateStrategy strategy) {
        Names names = ladderInformation.getNames();
        Ladder ladder = Ladder.createWithLadderInformation(ladderInformation, strategy);

        return new LadderGame(ladder, names);
    }

    public Ladder getLadder() {
        return ladder;
    }

    public Names getNames() {
        return names;
    }
}
