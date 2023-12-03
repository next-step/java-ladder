package nextstep.ladder.domain.line;

import nextstep.ladder.domain.participant.Participant;
import nextstep.ladder.domain.participant.Participants;

public class Line {
    private final int rowLineNumber;
    private RowLinePositions rowLinePosition;

    public Line(String[] participants) {
        int participantNumber = participants.length;
        rowLineNumber = participantNumber - 1;
        rowLinePosition = RowLinePositions.create(rowLineNumber);
    }

    public Line(int rowLineNumber) {
        this.rowLineNumber = rowLineNumber;
        rowLinePosition = RowLinePositions.create(rowLineNumber);
    }

    public Line(int rowLineNumber, RowLinePositions rowLinePositions) {
        this.rowLineNumber = rowLineNumber;
        this.rowLinePosition = rowLinePositions;
    }

    public boolean isTruePosition(int index) {
        return rowLinePosition.isTrue(index);
    }

    public void movableParticipants(Participants participants) {
        participants.getParticipantList()
                .stream()
                .forEachOrdered(participant -> movableParticipant(participant));
    }

    public void movableParticipant(Participant participant) {
        if (movableLeft(participant)) {
            return;
        }
        movableRight(participant);
    }

    private boolean movableLeft(Participant participant) {
        int index = participant.getCurrentIndex();
        if (index != 0 && isTruePosition(index -1)) {
            participant.moveLeft();
            return true;
        }
        return false;
    }

    private boolean movableRight(Participant participant) {
        int index = participant.getCurrentIndex();
        if (index != rowLineNumber && isTruePosition(index)) {
            participant.moveRight();
            return true;
        }
        return false;
    }
}
