package nextstep.laddergame.domain;

import nextstep.laddergame.service.LadderGameResult;
import nextstep.laddergame.service.LaddersFactory;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGame {
    private final Participants participants;
    private final Integer maxHeight;
    private final Ladders ladders;
    private final List<LadderOutput> ladderOutputs;

    public LadderGame(List<String> participants, List<String> ladderOutputs, Integer maxHeight, LaddersFactory laddersFactory, LadderLinesGenerator ladderLinesGenerator) {
        this(participants, ladderOutputs, maxHeight, laddersFactory.createLadders(participants.size(), maxHeight, ladderLinesGenerator));
    }

    private LadderGame(List<String> participants, List<String> ladderOutputs, Integer maxHeight, Ladders ladders) {
        this.participants = new Participants(participants);
        this.maxHeight = maxHeight;
        this.ladders = ladders;
        this.ladderOutputs = ladderOutputs.stream().map(LadderOutput::new).collect(Collectors.toList());
    }

    public LadderGameResult resolveGameResult(Participant participant) {
        Position ladderFinalPosition = participant.getPosition();
        int lineIndex = 0;
        while (lineIndex < maxHeight) {
            ladderFinalPosition = moveOrNot(ladderFinalPosition, lineIndex);
            lineIndex++;
        }
        return new LadderGameResult(participant, ladderOutputs.get(ladderFinalPosition.value()));
    }

    private Position moveOrNot(Position ladderFinalPosition, int lineIndex) {
        if (ladders.isMovableLadder(ladderFinalPosition, lineIndex)) {
            return ladderFinalPosition.move(ladders.resolveMoveDirection(ladderFinalPosition, lineIndex));
        }
        return ladderFinalPosition;
    }

    public Participants getParticipants() {
        return participants;
    }

    public Integer getMaxHeight() {
        return maxHeight;
    }

    public Ladders getLadders() {
        return ladders;
    }

    public int getLaddersSize() {
        return ladders.size();
    }

    public Participant getParticipant(String participantName) {
        return participants.getParticipantBy(participantName);
    }

    public List<LadderOutput> getLadderOutputs() {
        return ladderOutputs;
    }
}
