package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Players {
    private final List<Player> playerList;

    public Players(List<String> names) {
        playerList = new ArrayList<>(names.size());
        for (int i = 0; i < names.size(); i++) {
            playerList.add(new Player(names.get(i), new Point(i)));
        }
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

    public int findPlayerIndex(Player player) {
        return IntStream.range(0, playerList.size())
                .filter(i -> player.equals(playerList.get(i)))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 플레이어는 존재하지 않습니다."));
    }

    public void updatePlayerPoint(Player player, Point newPoint) {
        playerList.set(findPlayerIndex(player), player.move(newPoint));
    }

    public Stream<Player> stream() {
        return playerList.stream();
    }
}
