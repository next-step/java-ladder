package nextstep.ladder.service;

import nextstep.ladder.domain.Lines;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.strategy.LadderLineStrategy;

public class LadderService {

    public Participants getParticipants(String names) {
        return new Participants(names);
    }

    public Lines createLadder(Participants participants, int maxLadder) {
        Lines lines = new Lines();
        lines.generateLine(participants.size(), maxLadder, new LadderLineStrategy());
        return lines;
    }

}
