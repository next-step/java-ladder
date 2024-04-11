package ladder.domain.factory;

import ladder.domain.Player;
import ladder.domain.Players;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class PlayerFactory {

    private static final int MIN_PLAYERS = 2;

    private PlayerFactory() {
    }

    public static Players create(List<String> playersNames){
        return new Players(createPlayers(playersNames));
    }

    private static List<Player> createPlayers(List<String> playersNames){
        validatePlayers(playersNames);

        return IntStream.range(0, playersNames.size())
                .mapToObj(index -> new Player(playersNames.get(index), index))
                .collect(Collectors.toList());
    }

    private static void validatePlayers(List<String> playersNames){
        if (playersNames.size() < MIN_PLAYERS){
            throw new IllegalArgumentException("참가자는 최소 2명 이상이어야 합니다.");
        }
    }
}
