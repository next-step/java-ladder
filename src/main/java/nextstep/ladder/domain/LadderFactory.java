package nextstep.ladder.domain;

import nextstep.ladder.strategy.LadderLineStrategy;

public class LadderFactory {

    public static Lines createLadder(Participants participants, int maxLadder) {
        Lines lines = new Lines();
        lines.generateLine(participants.size(), maxLadder, new LadderLineStrategy());
        return lines;
    }

}
