package ladder.model.stringas;

import ladder.model.Player;

import java.util.List;
import java.util.stream.Collectors;

public class Players {

    private static final int MIN_PLAYER_COUNT = 2;
    private final List<Player> players;

    public Players(String players) {
        this.players = toPlayerList(players);
    }

    private List<Player> toPlayerList(String players) {
        List<Player> list = new Names(players).getNames()
                            .stream()
                            .map(Player::new)
                            .collect(Collectors.toList());
        checkValidation(list);
        return list;
    }

    private void checkValidation(List<Player> list) {
        if(list.size() < MIN_PLAYER_COUNT) {
            throw new IllegalArgumentException("게임을 하려면 최소 " + MIN_PLAYER_COUNT + "명이 필요합니다.");
        }
    }
}
