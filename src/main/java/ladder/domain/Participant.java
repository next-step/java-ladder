package ladder.domain;

import ladder.exception.InvalidCountOfPersonException;
import ladder.exception.InvalidPersonNameException;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Participant {
    private static final int NAME_LENGTH_THRESHOLD = 6;
    private static final int REQUIRED_NUMBER_OF_PEOPLE = 2;

    private final List<String> participant;

    private Participant(List<String> participant) {
        validateCountOfPerson(participant.size());
        validateName(participant);
        this.participant = participant;
    }

    private void validateCountOfPerson(int countOfPerson) {
        if (countOfPerson < REQUIRED_NUMBER_OF_PEOPLE) {
            throw new InvalidCountOfPersonException();
        }
    }

    private void validateName(List<String> participant) {
        participant.stream()
                .filter(person -> person.length() > NAME_LENGTH_THRESHOLD)
                .findAny()
                .ifPresent(person -> {
                    throw new InvalidPersonNameException(person);
                });
    }

    public static Participant of(List<String> participant) {
        return new Participant(participant);
    }

    public List<String> getList() {
        return Collections.unmodifiableList(participant);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participant that = (Participant) o;
        return Objects.equals(participant, that.participant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(participant);
    }

    public ParticipateNumber getParticipationNumber(String person) {
        return ParticipateNumber.of(participant.indexOf(person));
    }
}
