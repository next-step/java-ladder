package laddergame.dto;

import laddergame.domain.Ladder;
import laddergame.domain.ParticipantName;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LadderGameResult {

    private final List<String> participantNames;
    private final LadderDto ladder;

    public LadderGameResult(List<String> participantNames, LadderDto ladder) {
        this.participantNames = participantNames;
        this.ladder = ladder;
    }

    public static LadderGameResult of(List<ParticipantName> participantNames, Ladder ladder) {
        List<String> participantNameValues = participantNames.stream()
                .map(ParticipantName::toString)
                .collect(Collectors.toList());
        LadderDto ladderDto = LadderDto.from(ladder);
        return new LadderGameResult(participantNameValues, ladderDto);
    }

    public List<String> getParticipantNames() {
        return participantNames;
    }

    public LadderDto getLadder() {
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
