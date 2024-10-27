package nextstep.ladder.v2.model;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderResult {
    private Map<Player, Prize> result;

    public LadderResult(Map<Player, Prize> result) {
        this.result = result;
    }

    public static LadderResult of(List<Player> players, List<Prize> prizes) {
        LinkedHashMap<Player, Prize> result = IntStream.range(0, players.size())
                .boxed()
                .collect(Collectors.toMap(
                        players::get,
                        prizes::get,
                        (existing, replacement) -> existing,
                        LinkedHashMap::new
                ));
        return new LadderResult(result);
    }

    public Map<Player, Prize> getAllResult() {
        return result;
    }

    public Map<Player, Prize> getResultByPlayer(Player player) {
        Prize prize = this.result.get(player);
        HashMap<Player, Prize> result = new HashMap<>();
        result.put(player, prize);
        return result;
    }
}
