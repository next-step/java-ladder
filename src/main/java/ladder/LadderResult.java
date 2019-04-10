package ladder;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class LadderResult {

    private Map<Player, String> ladderResult = new LinkedHashMap<>();


    public LadderResult(Ladder ladder, LadderPlayers players, Prizes prizes) {
        createResult(ladder, players, prizes);
    }

    private void createResult(Ladder ladder, LadderPlayers players, Prizes prizes) {
        for (Player player : players.getPlayers()) {
            int point = ladder.move(players.indexOf(player));
            ladderResult.put(player, prizes.get(point));
        }
    }

    public Map<Player, String> getLadderResult() {
        return ladderResult;
    }

    public String getResultPrize(String name) throws IllegalArgumentException {
        return Optional.ofNullable(ladderResult.get(new Player(new PlayerName(name))))
            .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 사용자입니다."));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderResult that = (LadderResult) o;
        return Objects.equals(ladderResult, that.ladderResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladderResult);
    }
}
