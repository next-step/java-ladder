package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ladder.domain.core.line.Line;
import ladder.domain.core.line.move.MovableLine;
import ladder.domain.core.line.name.LadderResultLine;
import ladder.domain.core.line.name.ParticipantsLine;
import ladder.ui.LadderBaseInputData;

class LineTransformationForLadder {
    static final String ERROR_MSG_PARTICIPANTS_LINE = "참가자 신청을 먼저 진행해 주세요.";
    static final String ERROR_MSG_MOVABLE_LINE = "참가자 신청을 먼저 신청후에 사다리 높이 정보를 설정해 주세요.";
    static final String ERROR_MSG_LADDER_RESULT_LINE = "참가자, 사다리 높이 정보를 먼저 신청후에 사다리 결과 정보를 설정해 주세요.";
    static final String ERROR_MSG_NOT_MATCH = "사다리에 설정된 모든 정보가 적합하지 않습니다.";
    private final int LADDER_SIZE = 3;
    private final List<Line> ladder;
    private int numberOfParticipants;

    LineTransformationForLadder() {
        ladder = new ArrayList<>(LADDER_SIZE);
        numberOfParticipants = 0;
    }

    static Ladder create(LadderBaseInputData ladderBaseInputData) {
        return new LineTransformationForLadder()
            .participantsLine(ladderBaseInputData.getParticipants())
            .movableLine(ladderBaseInputData.getLadderHeight())
            .ladderResultLine(ladderBaseInputData.getLadderResult())
            .build()
            ;
    }

    LineTransformationForLadder participantsLine(String participants) {
        if (0 != ladder.size()) {
            throw new IllegalArgumentException(ERROR_MSG_PARTICIPANTS_LINE);
        }
        ParticipantsLine participantsLine = ParticipantsLine.of(participants);
        numberOfParticipants = participantsLine.getWidth();
        ladder.add(participantsLine);
        return this;
    }

    LineTransformationForLadder movableLine(int ladderHeight) {
        if (1 != ladder.size()) {
            throw new IllegalArgumentException(ERROR_MSG_MOVABLE_LINE);
        }
        ladder.add(MovableLine.of(ladderHeight, numberOfParticipants));
        return this;
    }

    LineTransformationForLadder ladderResultLine(String ladderResults) {
        if (2 != ladder.size()) {
            throw new IllegalArgumentException(ERROR_MSG_LADDER_RESULT_LINE);
        }
        ladder.add(LadderResultLine.of(ladderResults));
        return this;
    }

    private boolean allMatchWithNumberOfParticipants(int count){
        return numberOfParticipants == count;
    }

    Ladder build(){
        boolean allMatch = ladder.stream()
                          .mapToInt(Line::getWidth)
                          .allMatch(this::allMatchWithNumberOfParticipants);
        if (!allMatch && LADDER_SIZE != ladder.size()){
            throw new IllegalArgumentException(ERROR_MSG_NOT_MATCH);
        }
        return new Ladder(Collections.unmodifiableList(ladder));
    }
}
