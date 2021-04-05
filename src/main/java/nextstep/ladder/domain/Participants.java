package nextstep.ladder.domain;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Participants {

    private final List<User> users;

    private Participants(final String... users) {
        this.users = parseUsers(users);
    }

    private List<User> parseUsers(final String... users) {
        AtomicInteger index = new AtomicInteger();
        return Arrays.stream(users)
                .map(user -> User.valueOf(user, index.getAndIncrement()))
                .collect(Collectors.toList());
    }

    public static Participants valueOf(final String... users) {
        return new Participants(users);
    }

    public int size() {
        return users.size();
    }

    public List<User> getUsers() {
        return Collections.unmodifiableList(users);
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
