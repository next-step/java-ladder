package nextstep.ladder.domain;

import java.util.Map;

public class PrizeMapper {
    private final Prizes prizes;
    private final Players players;

    public PrizeMapper(Prizes prizes, Players players) {
        if (players.getPlayerCount() != prizes.getPrizeCount()) {
            throw new IllegalArgumentException("Prize 개수와 Player 참가자 수는 반드시 같아야 합니다.");
        }
        this.prizes = prizes;
        this.players = players;
    }

    public PrizeMap getPlayersPrizes(Map<Point, Point> prizePair) {
        PrizeMap prizeMap = new PrizeMap();
        prizePair.keySet()
                .forEach(point -> prizeMap.put(players.get(point.getIndex()), prizes.get(prizePair.get(point).getIndex())));
        return prizeMap;
    }

    public int getPlayerCount() {
        return players.getPlayerCount();
    }
}
