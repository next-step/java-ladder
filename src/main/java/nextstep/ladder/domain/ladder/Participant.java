package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.exception.InvalidNameLengthException;

import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;
import static nextstep.ladder.utils.Validation.checkNotEmpty;

public class Participant {

    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public Participant(String name) {
        checkNameLength(name);
        this.name = name;
    }

    public static List<Participant> listOf(List<String> participants) {
        checkNotEmpty(participants);
        return participants.stream()
                .map(Participant::new)
                .collect(toList());
    }

    private void checkNameLength(String name) {
        if (name == null || name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
            throw new InvalidNameLengthException(MIN_NAME_LENGTH, MAX_NAME_LENGTH);
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participant that = (Participant) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Participant{" +
                "name='" + name + '\'' +
                '}';
    }
}
