package ladder.domain.service;

import ladder.domain.model.Player;
import ladder.domain.model.PlayerNames;
import ladder.domain.model.Players;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PlayerService {
    // singleton 적용
    private static PlayerService playerService = null;

    private PlayerService() {

    }

    public static PlayerService createPlayerService() {
        if (Objects.isNull(playerService)) {
            return new PlayerService();
        }
        return playerService;
    }

    public Players createPlayers(PlayerNames playerNames) {
        return new Players(IntStream.range(0, playerNames.getCount())
                .mapToObj(index -> new Player(playerNames.getPlayerNames().get(index), index)).collect(Collectors.toList()));
    }
}
