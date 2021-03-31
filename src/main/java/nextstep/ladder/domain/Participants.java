package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Participants {

    private static final String SPLIT_DELIMITER = ",";
    private final List<Name> users;

    private Participants(final String users) {
        this.users = parseUsers(users);
    }

    private List<Name> parseUsers(final String users) {
        return Arrays.stream(users.split(SPLIT_DELIMITER))
                .map(String::trim)
                .map(Name::of)
                .collect(Collectors.toList());
    }

    public static Participants valueOf(final String users) {
        return new Participants(users);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Participants)) return false;
        final Participants that = (Participants) o;
        return Objects.equals(users, that.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(users);
    }

    @Override
    public String toString() {
        return String.valueOf(users);
    }
}
