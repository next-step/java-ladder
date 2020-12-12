package nextstep.ladder.domain;

import java.util.List;

public class GameCriteria {
    private Users users;
    private Results result;
    private Height height;

    private GameCriteria(Users users, Results result, Height height) {
        this.users = users;
        this.result = result;
        this.height = height;
    }

    public static GameCriteria of(Users users, Results result, Height height) {
        return new GameCriteria(users, result, height);
    }

    public Users getUsers() {
        return users;
    }

    public Results getResult() {
        return result;
    }

    public Height getHeight() {
        return height;
    }

    public List<User> getUserList() {
        return users.getUsers();
    }
}
