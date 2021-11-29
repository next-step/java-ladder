package nextstep.ladder.domain.ladder;

import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toUnmodifiableList;
import static nextstep.ladder.utils.Validator.checkNotNull;

public class Participant {

    public static final String ILLEGAL_LENGTH_ERROR_MESSAGE = "이름의 길이는 1이상 5이하만 가능합니다.";
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public Participant(String name) {
        checkLength(name);
        this.name = name;
    }

    private void checkLength(String name) {
        if (name == null || name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ILLEGAL_LENGTH_ERROR_MESSAGE);
        }
    }

    public static List<Participant> listOf(List<String> names) {
        checkNotNull(names);
        return names.stream()
                .map(Participant::new)
                .collect(toUnmodifiableList());
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
