package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PlayerList {

    private List<Player> playerList;

    public PlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    public static PlayerList of(String[] nameList) {
        List<Player> list = IntStream.range(0, nameList.length)
                .mapToObj(i -> new Player(nameList[i], i))
                .collect(Collectors.toList());
        return new PlayerList(list);
    }

    private void add(String name, int ladderNumber) {
        playerList.add(new Player(name, ladderNumber));
    }

    public int size() {
        return playerList.size();
    }

    public List<Player> playerList() {
        return Collections.unmodifiableList(new ArrayList<>(playerList));
    }

    public Player player(String playerName) {
        return playerList.stream()
                .filter(player -> player.isMatch(playerName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("참가하지 않는 플레이어 이름 입니다."));
    }
}
