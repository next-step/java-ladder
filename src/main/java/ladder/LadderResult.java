package ladder;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class LadderResult {

    private Map<String, String> ladderResult = new HashMap<>();


    public LadderResult(Ladder ladder, LadderPlayers players, Prizes prizes) {
        createResult(ladder, players, prizes);
    }

    private void createResult(Ladder ladder, LadderPlayers players, Prizes prizes) {
        for (Player player : players.getPlayers()) {
            int point = ladder.move(players.getPlayer(player));
            ladderResult.put(player.getName(), prizes.get(point));
        }
    }

    public Map<String, String> getLadderResult() {
        return ladderResult;
    }

    public String getResultPrize(String name) throws IllegalArgumentException {
        return Optional.ofNullable(ladderResult.get(name))
            .orElseThrow(()-> new IllegalArgumentException("존재하지 않는 사용자입니다."));
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
