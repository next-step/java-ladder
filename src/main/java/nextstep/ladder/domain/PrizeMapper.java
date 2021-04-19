package nextstep.ladder.domain;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.IntStream;

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

    public Prize getPrizeByPlayerName(String name) {
        return getPrizeByPlayer(players.findPlayerByName(name));
    }

    private Prize getPrizeByPlayer(Player player) {
        return IntStream.range(0, prizes.getPrizeCount())
                .filter(i -> player.isPlayerInPosition(new Point(i)))
                .mapToObj(prizes::get)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("플레이어 위치에 맞는 Prize을 찾을 수 없습니다."));
    }

    public Map<Player, Prize> getAllPlayersPrizes() {
        Map<Player, Prize> prizeMap = new LinkedHashMap<>();
        players.stream()
                .forEach(player -> prizeMap.put(player, getPrizeByPlayer(player)));
        return prizeMap;
    }
}
