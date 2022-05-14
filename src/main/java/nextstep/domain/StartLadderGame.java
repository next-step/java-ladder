package nextstep.domain;

import java.util.List;
import java.util.stream.Collectors;

public class StartLadderGame {
    private final Users users;
    private final Ladder ladder;

    public StartLadderGame(Users users, Ladder ladder) {
        this.users = users;
        this.ladder = ladder;
        start();
    }

    private void start() {
        this.ladder.moveLines();
    }

    public String findUserResult(String username) {
        return this.ladder.find(this.users.findUsernameIndex(username));
    }

    public List<String> findAll() {
        return this.users.getUsers()
            .stream()
            .map(u -> this.ladder.find(users.findUsernameIndex(u.getUserName())))
            .collect(Collectors.toList());
    }

    public Ladder getLadder() {
        return this.ladder;
    }

    public List<User> getUsers() {
        return this.users.getUsers();
    }

}
