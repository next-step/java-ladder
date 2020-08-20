package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ladder.domain.core.line.Line;
import ladder.domain.core.line.move.MovableLine;
import ladder.domain.core.line.name.ParticipantsLine;

public class LadderBuilder {
    static final String ERROR_MSG_PARTICIPANTS_LINE = "참가자 신청을 먼저 진행해 주세요.";
    static final String ERROR_MSG_MOVABLE_LINE = "참가자 신청을 먼저 신청후에 사다리 정보를 설정해 주세요.";
    private List<Line> ladder;
    private int numberOfParticipants;

    LadderBuilder() {
        ladder = new ArrayList<>(2);
        numberOfParticipants = 0;
    }

    public LadderBuilder participantsLine(String participants) {
        if (0 != ladder.size()) {
            throw new IllegalArgumentException(ERROR_MSG_PARTICIPANTS_LINE);
        }
        ParticipantsLine participantsLine = ParticipantsLine.of(participants);
        numberOfParticipants = participantsLine.getNumberOfParticipants();
        ladder.add(participantsLine);
        return this;
    }

    public LadderBuilder movableLines(int ladderHeight) {
        if (1 != ladder.size()) {
            throw new IllegalArgumentException(ERROR_MSG_MOVABLE_LINE);
        }
        ladder.add(MovableLine.of(ladderHeight, numberOfParticipants));
        return this;
    }

    public Ladder build(){
        return new Ladder(Collections.unmodifiableList(ladder));
    }
}
