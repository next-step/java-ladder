package nextstep.ladder.domain;

public class GameInfo {
    private Users users;
    private Results results;

    public GameInfo(Users users, Results results) {
        users.checkValidateResults(results);
        this.users = users;
        this.results = results;
    }

    public Users getUsers() {
        return users;
    }

    public Results getResults() {
        return results;
    }
}
