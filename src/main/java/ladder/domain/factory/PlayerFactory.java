package ladder.domain.factory;

import ladder.domain.Player;
import ladder.domain.Players;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class PlayerFactory {

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

//        List<Player> playerList = new ArrayList<>();
//        for (int index = 0; index < playersNames.size(); index++) {
//            Player player = new Player(playersNames.get(index), index);
//            playerList.add(player);
//        }
//
//        return playerList;

//        return playersNames.stream()
//                .map(Player::new)
//                .collect(Collectors.toList());
    }

    private static void validatePlayers(List<String> playersNames){
        if (playersNames.size() < 2){
            throw new IllegalArgumentException("참가자는 최소 2명 이상이어야 합니다.");
        }
    }
}
