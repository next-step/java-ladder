package nextstep.step4.domain;

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

    public int getUserNumbers() {
        return users.getUserNumbers();
    }

}
