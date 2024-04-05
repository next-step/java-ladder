package ladder.domain.factory;

import ladder.domain.Player;
import ladder.domain.Players;

import java.util.List;
import java.util.stream.Collectors;

public class PlayerFactory {

    public static Players create(List<String> playersNames){
        return new Players(createPlayers(playersNames));
    }

    private static List<Player> createPlayers(List<String> playersNames){
        return playersNames.stream()
                .map(Player::new)
                .collect(Collectors.toList());
    }
}
