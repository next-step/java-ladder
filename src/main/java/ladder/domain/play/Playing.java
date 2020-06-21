package ladder.domain.play;

public class Playing {
    private final Items players;
    private final Items results;

    private Playing(Items players, Items results) {
        mustBeSameSize(players, results);
        this.players = players;
        this.results = results;
    }

    private void mustBeSameSize(Items players, Items results) {
        if (!players.sameSize(results)) {
            throw new IllegalArgumentException("참여자 갯수와 결과 갯수가 동일해야 합니다.");
        }
    }

    public static Playing of(Items players, Items results) {
        return new Playing(players, results);
    }
}
