package ladder.domain;

import ladder.exception.NotFoundNameException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Players {
    private static final String NOT_FOUND_NAME_MESSAGE = "일치하는 결과가 없습니다.";

    private final List<Player> playerList = new ArrayList<>();

    public Players(List<String> nameList) {
        for (int i = 0; i < nameList.size(); i++) {
            playerList.add(new Player(nameList.get(i), i));
        }
    }

    public List<String> names() {
        return playerList.stream()
                .map(Player::name)
                .collect(Collectors.toList());
    }

    public Player findByName(String playerName) {
        return playerList.stream()
                .filter(player -> Objects.equals(player.name(), playerName))
                .findFirst()
                .orElseThrow(() -> new NotFoundNameException(NOT_FOUND_NAME_MESSAGE));
    }

    public Integer playerSize() {
        return this.playerList.size();
    }

    public List<Player> getPlayerList() {
        return playerList;
    }
}
