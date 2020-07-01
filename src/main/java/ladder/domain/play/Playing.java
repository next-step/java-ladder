package ladder.domain.play;

import java.util.ArrayList;
import java.util.List;

public class Playing {
    private final Players players;
    private final Prizes prizes;

    private Playing(Players players, Prizes prizes) {
        mustBeSameSize(players, prizes);
        this.players = players;
        this.prizes = prizes;
    }

    private void mustBeSameSize(Items players, Items prizes) {
        if (!players.sameSize(prizes)) {
            throw new IllegalArgumentException("참여자 갯수와 결과 갯수가 동일해야 합니다.");
        }
    }

    public static Playing of(Players players, Prizes prizes) {
        return new Playing(players, prizes);
    }

    public int getCountOfPlayers() {
        return players.getCountOf();
    }

    public Player getPlayersBy(int index) {
        return players.get(index);
    }

    public Prize getResultsBy(int index) {
        return prizes.get(index);
    }

    public Players getPlayers() {
        return players;
    }

    public Prizes getPrizes() {
        return prizes;
    }

    public List<Integer> findPlayerIndexBy(String name) {
        List<Integer> indexes = new ArrayList<>();
        indexes.addAll(players.findIndexesBy(name));

        return indexes;
    }
}