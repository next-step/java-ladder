package nextstep.ladder.domain;

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

}
