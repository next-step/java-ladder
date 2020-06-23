package ladder.domain.play;

public class Playing {
    private final Players players;
    private final Results results;

    private Playing(Players players, Results results) {
        mustBeSameSize(players, results);
        this.players = players;
        this.results = results;
    }

    private void mustBeSameSize(Players players, Results results) {
        if (!players.sameSize(results)) {
            throw new IllegalArgumentException("참여자 갯수와 결과 갯수가 동일해야 합니다.");
        }
    }

    public static Playing of(Players players, Results results) {
        return new Playing(players, results);
    }

    public int getCountOfPlayers() {
        return players.getCountOf();
    }

    public Players getPlayers() {
        return players;
    }

    public Results getResults() {
        return results;
    }
}
