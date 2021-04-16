package ladder.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class LadderResult {
    private final Players players;
    private final LineResults lineResults;
    private final LadderMap ladderMap;

    public LadderResult(Players players, LineResults lineResults) {
        this.players = players;
        this.lineResults = lineResults;
        this.ladderMap = makeMap();
    }

    private LadderMap makeMap() {
        Map<Integer, Integer> radderMap = new HashMap<>();
        IntStream.range(0, players.count())
                .forEach(index -> {
                    int arrivalIndex = lineResults.arrivalPoint(0, index);
                    radderMap.put(index, arrivalIndex);
                });
        return new LadderMap(radderMap);
    }

    public Players getPlayers() {
        return players;
    }

    public List<Line> getLines() {
        return lineResults.getLines();
    }

    public String playersPrize(Player player, Prize prize) {
        int arrivalIndex = ladderMap.getArrivalIndex(players.index(player));
        return prize.prizeOfIndex(arrivalIndex);
    }

    public Map<String, String> playersPrizeAll(Prize prize) {
        Map<String, String> playersPrizeMap = new HashMap<>();
        players.allPlayers()
                .forEach(player -> playersPrizeMap.put(player.getName(), playersPrize(player, prize)));
        return playersPrizeMap;
    }
}
