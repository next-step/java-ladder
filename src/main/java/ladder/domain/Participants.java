package ladder.domain;

import ladder.utils.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Participants {

    public static final String ALL = "all";
    private static final String PARTICIPANTS_DELIMITER = ",";
    private List<Participant> participants;

    public Participants(String participants) {

        if (StringUtils.isBlank(participants)) {
            throw new IllegalArgumentException("참가자명이 유효하지 않습니다.");
        }

        this.participants = StringUtils.split(participants, PARTICIPANTS_DELIMITER)
                .stream()
                .map(Participant::new)
                .collect(Collectors.toList());
    }

    public List<String> getParticipantsName() {

        return participants.stream()
                .map(Participant::getName)
                .collect(Collectors.toList());
    }

    public Participant getParticipant(int index) {

        return participants.get(index);
    }

    public int size() {

        return participants.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participants that = (Participants) o;
        return Objects.equals(participants, that.participants);
    }

    @Override
    public int hashCode() {
        return Objects.hash(participants);
    }
}
