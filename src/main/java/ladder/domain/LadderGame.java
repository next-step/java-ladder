package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LadderGame {

    private static final String ALL = "all";

    private final Ladder ladder;

    private final Participants participants;

    private final LadderResults ladderResult;


    public LadderGame(Ladder ladder, Participants participants, LadderResults ladderResult) {
        this.ladder = ladder;
        this.participants = participants;
        this.ladderResult = ladderResult;
    }

    public List<Participant> getParticipants() {
        return participants.getParticipants();
    }

    public List<Line> getLines() {
        return ladder.getLines();
    }

    public List<LadderResult> getResults() {
        return ladderResult.getResults();
    }

    public List<LadderResultPrint> process(Participant participant) {
        if (participant.getName().equals(ALL)) {
            return allResult();
        }

        return singlePrint(participant);
    }

    private List<LadderResultPrint> singlePrint(Participant participant) {
        int resultPosition = ladder.resultPosition(participants.getIndex(participant));
        LadderResult ladderResultPosition = ladderResult.getPosition(resultPosition);
        return Collections.singletonList(new LadderResultPrint(participant, ladderResultPosition));
    }

    private List<LadderResultPrint> allResult() {
        List<Integer> participantIndices = participants.getParticipants().stream()
                .map(participants::getIndex)
                .collect(Collectors.toList());

        List<Integer> resultIndices = ladder.resultPositions(participantIndices);

        return participantIndices.stream()
                .map(index -> new LadderResultPrint(participants.getParticipant(index),
                        ladderResult.getPosition(resultIndices.get(index))))
                .collect(Collectors.toList());
    }

}
