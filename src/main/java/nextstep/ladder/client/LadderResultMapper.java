package nextstep.ladder.client;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import nextstep.ladder.domain.LadderResult;
import nextstep.ladder.domain.player.Player;

public class LadderResultMapper {

    private LadderResult result;
    private List<Player> players;
    private List<String> prizes;

    LadderResultMapper(LadderResult result, List<Player> players, List<String> prizes) {
        this.result = result;
        this.players = players;
        this.prizes = prizes;
    }

    Map<String, String> getPlayerPrizes() {
        Map<String, String> playerPrizes = new LinkedHashMap<>();
        for (int position = 0; position < players.size(); position++) {
            playerPrizes.put(players.get(position).getName(), prizes.get(result.get(position)));
        }

        return playerPrizes;
    }

    String getPrize(String playerName) {
        int position = this.players.indexOf(new Player(playerName));
        return prizes.get(result.get(position));
    }
}
