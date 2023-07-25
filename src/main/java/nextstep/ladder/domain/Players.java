package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import nextstep.ladder.domain.dto.Rewards;

public class Players {

    private final List<Player> playerResults = new ArrayList<>();

    public Players(PlayerNames playerNames, MatchingResult matchingResult, Rewards rewards) {
        for (int i = 0; i < playerNames.size(); i++) {
            Player player = new Player(
                playerNames.get(i),
                rewards.get(matchingResult.getResult(i)));
            this.playerResults.add(player);
        }
    }

    public String getResult(PlayerName playerName) {
        return this.playerResults.stream()
            .filter(player -> player.getPlayerName().equals(playerName))
            .findFirst()
            .orElseThrow()
            .getResult();
    }

    public List<Player> asList() {
        return this.playerResults;
    }

    public int size() {
        return this.playerResults.size();
    }
}
