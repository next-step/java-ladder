package step4.laddergame.domain.ladder;

import step4.laddergame.domain.player.Player;
import step4.laddergame.domain.player.Players;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LadderWinning {
    private final Map<Player, Result> winning;

    public LadderWinning() {
        winning = new LinkedHashMap<>();
    }

    public LadderWinning(Map<Player, Result> winning) {
        this.winning = winning;
    }

    public static LadderWinning of(Players players, List<Result> resultList) {
        Map<Player, Result> winning = new LinkedHashMap<>();
        players.match(resultList, winning);
        return new LadderWinning(winning);
    }

    public Result findOne(String name) {
        return winning.get(Player.of(name));
    }

    public Map<Player, Result> getWinning() {
        return Collections.unmodifiableMap(winning);
    }
}
