package nextstep.ladder.wrapper;

import nextstep.ladder.domain.Position;
import nextstep.ladder.domain.Reward;
import nextstep.ladder.domain.User;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Participants {

    private final Set<User> users;

    private Participants(final String... users) {
        this.users = parseUsers(users);
    }

    private Set<User> parseUsers(final String... users) {
        return IntStream.range(0, users.length)
                .mapToObj(value -> User.valueOf(users[value], value))
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public static Participants valueOf(final String... users) {
        return new Participants(users);
    }

    public int size() {
        return users.size();
    }

    public Set<User> getUsers() {
        return Collections.unmodifiableSet(users);
    }

    public LadderResult findReward(final Ladder ladder, final LadderRewards ladderRewards) {
        Map<User, Reward> result = new HashMap<>();
        // TODO 스트림으로 한 번에 할 수 있을 것 같은데
        users.forEach(user -> {
            Position endPosition = ladder.findEndPosition(user.position());
            result.put(user, ladderRewards.findReward(endPosition));
        });
        return LadderResult.valueOf(result);
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
