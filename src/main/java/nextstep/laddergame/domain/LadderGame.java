package nextstep.laddergame.domain;

import nextstep.laddergame.service.LadderGameResult;
import nextstep.laddergame.service.LaddersFactory;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LadderGame {
    private final Participants participants;
    private final Ladders ladders;
    private final List<LadderOutput> ladderOutputs;

    public LadderGame(List<String> participants, List<String> ladderOutputs, Integer maxHeight, LaddersFactory laddersFactory, LadderLinesGenerator ladderLinesGenerator) {
        this(participants, ladderOutputs, laddersFactory.createLadders(participants.size(), maxHeight, ladderLinesGenerator));
    }

    private LadderGame(List<String> participants, List<String> ladderOutputs, Ladders ladders) {
        this.participants = new Participants(participants);
        this.ladders = ladders;
        this.ladderOutputs = ladderOutputs.stream().map(LadderOutput::new).collect(Collectors.toList());
    }

    public LadderGameResult resolveGameResult(Participant participant) {
        return new LadderGameResult(
                participant,
                ladderOutputs.get(
                        ladders.resolveFinalPosition(participant.getPosition()).value()));
    }

    public Participants getParticipants() {
        return participants;
    }

    public Ladders getLadders() {
        return ladders;
    }

    public Integer getLaddersLineSize() {
        return ladders.lineSize();
    }

    public int getLaddersSize() {
        return Objects.isNull(ladders) ? 0 : ladders.size();
    }

    public Participant getParticipant(String participantName) {
        return participants.getParticipantBy(participantName);
    }

    public List<LadderOutput> getLadderOutputs() {
        return ladderOutputs;
    }
}
