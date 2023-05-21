package nextstep.ladder.domain.user;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Users {

    private static final int START = 0;
    private static final int WIDTH_OUT_OF_RANGE_BLOCK_NUMBER = 1;
    private final List<User> users;

    public Users() {
        this.users = new ArrayList<>();
    }

    public void add(User user) {
        this.users.add(user);
    }

    public int userCount() {
        return this.users.size();
    }

    public IntStream toStream() {
        return IntStream.range(START, this.users.size() - WIDTH_OUT_OF_RANGE_BLOCK_NUMBER);
    }

    @Override
    public String toString() {
        return users.stream().map(User::toString).collect(Collectors.joining(""));
    }
}