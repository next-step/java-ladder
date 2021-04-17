package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PrizeMapper {
    private final Prizes prizes;
    private final Players players;

    public PrizeMapper(Prizes prizes, Players players) {
        this.prizes = prizes;
        this.players = players;
    }

    public List<String> getPlayerPrizeResult(String name) {
        if ("all".equals(name)) {
            return getAllPlayersPrize();
        }
        return Arrays.asList(prizes.givePrizeTo(players.findPlayerByName(name)).toString());
    }

    private List<String> getAllPlayersPrize() {
        return players.getAllPlayerNames().stream()
                .map(players::findPlayerByName)
                .map(player -> player.getName() + " : " + prizes.givePrizeTo(player))
                .collect(Collectors.toList());
    }
}
