package ladder.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class LadderResult {
    private final Ladder ladder;
    private final LadderMap ladderMap;

    public LadderResult(int count, Ladder ladder) {
        this.ladder = ladder;
        this.ladderMap = makeMap(count);
    }

    private LadderMap makeMap(int count) {
        Map<Integer, Integer> radderMap = new HashMap<>();
        IntStream.range(0, count)
                .forEach(index -> {
                    int arrivalIndex = ladder.arrivalPoint(index);
                    radderMap.put(index, arrivalIndex);
                });
        return new LadderMap(radderMap);
    }

    public List<Line> getLines() {
        return ladder.getLines();
    }

    public String playersPrize(PrizePlayer prizePlayer, Prize prize) {
        return playersPrize(prizePlayer.index(), prize);
    }

    public String playersPrize(int index, Prize prize) {
        int arrivalIndex = ladderMap.getArrivalIndex(index);
        return prize.prizeOfIndex(arrivalIndex);
    }

    public Map<String, String> playersPrizeAll(PrizePlayer prizePlayer, Prize prize) {
        Map<String, String> playersPrizeMap = new HashMap<>();
        prizePlayer.allPlayers()
                .forEach(player -> playersPrizeMap.put(player.getName(), playersPrize(prizePlayer.indexOf(player), prize)));
        return playersPrizeMap;
    }
}
