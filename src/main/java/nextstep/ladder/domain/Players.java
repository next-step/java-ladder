package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private final List<Player> playerList;

    public Players(List<String> names) {
        playerList = new ArrayList<>(names.size());
        for (int i = 0; i < names.size(); i++) {
            playerList.add(new Player(names.get(i)));
        }
    }

    public Player get(int i) {
        return playerList.get(i);
    }

    public Player findPlayerByName(String name) {
        return playerList.stream()
                .filter(p -> p.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 이름을 가진 플레이어가 없습니다."));
    }

    public int getPlayerCount() {
        return playerList.size();
    }

    public List<String> getAllPlayerNames() {
        return playerList.stream()
                .map(Player::getName)
                .collect(Collectors.toList());
    }
}
