package ladder.domain.play;

public class Playing {
    private final Players players;
    private final Results results;

    private Playing(Items players, Items results) {
        mustBeSameSize(players, results);
        this.players = Players.of(players);
        this.results = Results.of(results);
    }

    private void mustBeSameSize(Items players, Items results) {
        if (!players.sameSize(results)) {
            throw new IllegalArgumentException("참여자 갯수와 결과 갯수가 동일해야 합니다.");
        }
    }

    public static Playing of(Items players, Items results) {
        return new Playing(players, results);
    }

    public int getCountOfPlayers() {
        return players.getCountOf();
    }

    public Item getPlayersBy(int index) {
        return players.get(index);
    }

    public Item getResultsBy(int index) {
        return results.get(index);
    }

    public Players getPlayers() {
        return players;
    }

    public Results getResults() {
        return results;
    }
}