package nextstep.ladder.domain;

public class GameInfo {
    private Users users;
    private Results results;

    public GameInfo(Users users, Results results) {
        validateGameInfo(users, results);
        this.users = users;
        this.results = results;
    }

    public void validateGameInfo(Users users, Results results) {
        if (users.getCountOfPerson() != results.getResults().size()) {
            throw new IllegalArgumentException("참여할 사람과 실행 결과의 수는 같아야 합니다");
        }
    }

    public Users getUsers() {
        return users;
    }

    public Results getResults() {
        return results;
    }
}
