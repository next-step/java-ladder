package nextstep.step4.domain;

import java.util.List;

public class GameCriteria {

    private final Users users;
    private final Results results;

    private GameCriteria(Users users, Results results) {
        this.users = users;
        this.results = results;
    }

    public static GameCriteria of(Users users, Results results) {
        return new GameCriteria(users, results);
    }

    public List<User> getUserList() {
        return users.getUserList();
    }

    public List<Result> getResultList() {
        return results.getResultList();
    }

    public int getUserNumbers() {
        return users.getUserNumbers();
    }

}
