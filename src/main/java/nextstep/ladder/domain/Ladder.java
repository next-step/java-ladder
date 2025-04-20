package nextstep.ladder.domain;

import nextstep.ladder.domain.line.Dimension;
import nextstep.ladder.domain.prize.LadderPrizes;
import nextstep.ladder.domain.user.LadderUsers;
import nextstep.ladder.factory.LineFactory;
import nextstep.ladder.domain.line.Lines;
import nextstep.ladder.dto.LadderDto;

import java.util.List;

public class Ladder {
    private final LadderUsers ladderUsers;
    private final Lines lines;
    private final LadderPrizes ladderPrizes;

    public Ladder(LadderUsers ladderUsers, LadderPrizes ladderPrizes, Dimension dimension) {
        this(ladderUsers, ladderPrizes, dimension, new LineFactory());
    }

    public Ladder(LadderUsers ladderUsers, LadderPrizes ladderPrizes, Dimension height, LineFactory lineFactory) {
        if (ladderUsers.size() != ladderPrizes.size()) {
            throw new IllegalArgumentException("유저와 결과 수가 맞지 않습니다.");
        }

        this.ladderUsers = ladderUsers;
        this.ladderPrizes = ladderPrizes;
        this.lines = new Lines(new Dimension(ladderUsers.size()), height, lineFactory);
    }

    public List<String> getUsersNames() {
        return ladderUsers.getLadderUserNames();
    }

    public List<String> getPrizes() {
        return ladderPrizes.getLadderPrizes();
    }

    public List<List<Boolean>> getLadder() {
        return lines.getvalue();
    }

    public LadderResult simulate() {
        LadderUsers moved = lines.moveUsers(ladderUsers);
        return new LadderResult(moved, moved.selectPrizes(ladderPrizes));
    }
}
