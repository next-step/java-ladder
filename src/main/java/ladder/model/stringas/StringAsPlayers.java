package ladder.model.stringas;

import ladder.model.Player;

import java.util.List;
import java.util.stream.Collectors;

public class StringAsPlayers {

    private final static int MIN_PLAYER_COUNT = 2;
    private final StringAsNames stringAsNames;

    public StringAsPlayers(String players) {
        stringAsNames = new StringAsNames(players);
    }

    public List<Player> get() {
        List<Player> list = stringAsNames.get().stream()
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