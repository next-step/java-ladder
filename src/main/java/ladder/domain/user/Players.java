package ladder.domain.user;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Players {

    public static final String ERROR_EMPTY_MSG = "리스트가 비어있습니다..";
    public static final String NOT_FIND_PLAYER_ERROR_MSG = "맞는 이름이 없습니다.";

    private final List<Player> players;

    public Players(List<String> players) {
        if (players == null || players.size() == 0) {
            throw new IllegalArgumentException(ERROR_EMPTY_MSG);
        }
        this.players = toPlayers(players);
    }

    public int size() {
        return players.size();
    }

    private List<Player> toPlayers(List<String> players) {
        return players.stream()
                .map(name -> new Player(name.trim()))
                .collect(Collectors.toList());
    }

    public int findPlayers(String player) {
        return IntStream.range(0, players.size())
                .filter(index -> isSamePlayer(index, player))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_FIND_PLAYER_ERROR_MSG));
    }

    private boolean isSamePlayer(int index, String player) {
        return players.get(index).isSamePlayer(player);
    }

    public List<Player> getPlayers() {
        return players;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        Players players1 = (Players) o;
        return Objects.equals(players, players1.players);
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
