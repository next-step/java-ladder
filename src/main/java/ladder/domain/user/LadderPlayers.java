package ladder.domain.user;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LadderPlayers {

    public static final String ERROR_EMPTY_MSG = "리스트가 비어있습니다..";
    public static final String ERROR_NOT_FIND_PLAYER_MSG = "맞는 이름이 없습니다.";

    private final List<Player> players;

    public LadderPlayers(List<String> players) {
        if (Objects.isNull(players) || players.isEmpty()) {
            throw new IllegalArgumentException(ERROR_EMPTY_MSG);
        }
        this.players = toPlayers(players);
    }

    private List<Player> toPlayers(List<String> players) {
        return players.stream()
                .map(name -> new Player(name.trim()))
                .collect(Collectors.toList());
    }

    public int findIndexByName(String wantedName) {
        if (!getPlayerNames().contains(wantedName)) {
            throw new IllegalArgumentException(ERROR_NOT_FIND_PLAYER_MSG);
        }
        return getPlayerNames().indexOf(wantedName);
    }

    public List<String> getPlayerNames() {
        return players.stream()
                .map(Player::getPlayerName)
                .collect(Collectors.toList());
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(this.players);
    }

    public int size() {
        return players.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        LadderPlayers that = (LadderPlayers) o;
        return Objects.equals(players, that.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(players);
    }

    @Override
    public String toString() {
        return "Players{" +
                "players=" + players +
                '}';
    }

}
