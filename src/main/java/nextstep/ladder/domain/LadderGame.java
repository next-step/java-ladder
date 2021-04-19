package nextstep.ladder.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class LadderGame {
    private final PrizeMapper prizeMapper;
    private final Ladder ladder;

    public LadderGame(PrizeMapper prizeMapper, int height) {
        this.prizeMapper = prizeMapper;
        ladder = new Ladder(height, prizeMapper.getPlayerCount());
    }

    public List<String> build() {
        return ladder.build();
    }

    public Map<Player, Prize> start() {
        Map<Point, Point> mapper = new LinkedHashMap<>();
        IntStream.range(0, prizeMapper.getPlayerCount())
                .forEach(i -> mapper.put(new Point(i), ladder.ride(new Point(i))));
        return prizeMapper.getPlayersPrizes(mapper);
    }
}
