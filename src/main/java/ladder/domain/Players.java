package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Players {

    private static final String SELECT_ALL = "all";

    private final List<Player> playerList;

    public Players(List<Player> playerList) {
        this.playerList = playerList;
    }

    public List<Player> players(){
        return Collections.unmodifiableList(playerList);
    }

    public int count(){
        return playerList.size();
    }

    public Players of(List<String> playerNames) {
        if(playerNames.size() == 1 && Objects.equals(playerNames.get(0), SELECT_ALL)){
            return this;
        }

        List<Player> selectedPlayers = playerNames.stream()
                .map(this::findPlayer)
                .collect(Collectors.toList());
        return new Players(selectedPlayers);
    }

    private Player findPlayer(String playerName) {
        return playerList.stream()
                .filter(player -> Objects.equals(player.name(), playerName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("참가자를 찾을 수 없습니다: " + playerName));
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Players that = (Players) o;
        return Objects.equals(playerList, that.playerList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerList);
    }
}

