package ladder.service;

import ladder.domain.LadderHeight;
import ladder.domain.Lines;
import ladder.domain.User;
import ladder.domain.Users;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class LadderService {
    private final Users users;
    private final LadderHeight ladderHeight;
    private Lines lines;

    public LadderService(String[] users, String ladderHeight) {
        this.users = new Users(Arrays.stream(users)
                .map(user -> new User(user))
                .collect(Collectors.toList()));
        this.ladderHeight = new LadderHeight(ladderHeight);
    }

    public void play() {
        Lines lines = new Lines();
        lines.createLines(users.getUserCount(), ladderHeight.getHeight());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderService that = (LadderService) o;
        return Objects.equals(users, that.users) &&
                Objects.equals(ladderHeight, that.ladderHeight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(users, ladderHeight);
    }
}
