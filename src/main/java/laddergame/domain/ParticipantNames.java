package laddergame.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ParticipantNames {

    private final List<ParticipantName> participantNames;

    public ParticipantNames(List<ParticipantName> participantNames) {
        validate(participantNames);
        this.participantNames = participantNames;
    }

    private void validate(List<ParticipantName> participantNames) {
        if (getNumberOfDistinctParticipantNames(participantNames) != participantNames.size()) {
            throw new IllegalArgumentException("참가자 이름은 중복될 수 없습니다가.");
        }
    }

    private int getNumberOfDistinctParticipantNames(List<ParticipantName> participantNames) {
        return (int) participantNames.stream()
                .distinct()
                .count();
    }

    public static ParticipantNames from(List<String> participantNameValues) {
        List<ParticipantName> participantNames = participantNameValues.stream()
                .map(ParticipantName::new)
                .collect(Collectors.toList());
        return new ParticipantNames(participantNames);
    }

    public int size() {
        return participantNames.size();
    }


    public ParticipantName get(int index) {
        return participantNames.get(index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParticipantNames that = (ParticipantNames) o;
        return Objects.equals(participantNames, that.participantNames);
    }

    @Override
    public int hashCode() {
        return Objects.hash(participantNames);
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
