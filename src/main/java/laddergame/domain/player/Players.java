/*
 * 사다리타기 게임 참여자목록을 담당하는 클래스
 * */
package laddergame.domain.player;

import java.util.*;

import static laddergame.util.Message.ILLEGAL_DUPLICATE_NAME;
import static laddergame.util.Message.ILLEGAL_EMPTY_PLAYER;

public class Players {

    private List<Player> players = new ArrayList<>();

    public Players(List<Player> playerList) {
        emptyPlayers(playerList);
        validPlayers(playerList);
        this.players = playerList;
    }

    private boolean validPlayers(List<Player> playerList) {
        Set<Name> names = new HashSet<>();
        playerList.stream().forEach(player -> player.addName(names));
        if (names.size() != playerList.size()) {
            throw new IllegalArgumentException(ILLEGAL_DUPLICATE_NAME);
        }
        return true;
    }

    private boolean emptyPlayers(List<Player> playerList) {
        if (playerList == null || playerList.isEmpty() || playerList.size() == 0) {
            throw new IllegalArgumentException(ILLEGAL_EMPTY_PLAYER);
        }
        return true;
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Players players1 = (Players) o;
        return Objects.equals(players, players1.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(players);
    }

}
