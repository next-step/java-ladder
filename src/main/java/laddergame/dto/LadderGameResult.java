package laddergame.dto;

import laddergame.domain.Ladder;
import laddergame.domain.ParticipantName;

import java.util.List;
import java.util.Objects;

public class LadderGameResult {

    private final List<ParticipantName> participantNames;
    private final Ladder ladder;

    public LadderGameResult(List<ParticipantName> participantNames, Ladder ladder) {
        this.participantNames = participantNames;
        this.ladder = ladder;
    }

    public List<ParticipantName> getParticipantNames() {
        return participantNames;
    }

    public Ladder getLadder() {
        return ladder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderGameResult that = (LadderGameResult) o;
        return Objects.equals(participantNames, that.participantNames) && Objects.equals(ladder, that.ladder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(participantNames, ladder);
    }

    @Override
    public String toString() {
        return "LadderGameResult{" +
                "participantNames=" + participantNames +
                ", ladder=" + ladder +
                '}';
    }

}
