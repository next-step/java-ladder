package ladder.service;

import ladder.domain.LadderHeight;
import ladder.domain.Lines;
import ladder.domain.User;
import ladder.domain.Users;
import ladder.view.OutputView;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class LadderService {
    private final Users users;
    private final LadderHeight ladderHeight;

    public LadderService(String[] users, String ladderHeight) {
        this.users = new Users(Arrays.stream(users)
                .map(user -> new User(user))
                .collect(Collectors.toList()));
        this.ladderHeight = new LadderHeight(ladderHeight);
    }

    public void play() {
        Lines lines = Lines.createLines(users.getUserCount(), ladderHeight.getHeight());
        OutputView.resultLadder();
        OutputView.drawLadderUsers(users);
        OutputView.drawLadderLines(lines);
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
