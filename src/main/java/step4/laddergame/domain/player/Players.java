/*
 * 사다리타기 게임 참여자목록을 담당하는 클래스
 * */
package step4.laddergame.domain.player;

import com.google.common.collect.Streams;
import step4.laddergame.domain.ladder.Result;

import java.util.*;

import static java.util.stream.Collectors.toCollection;

public class Players {
    private static final String ILLEGAL_DUPLICATE_NAME = "참여자의 이름은 중복될 수 없습니다.";
    private static final String ILLEGAL_EMPTY_PLAYER = "참여자는 한 명 이상이어야합니다.";

    private final List<Player> players;

    public Players(List<Player> playerList) {
        emptyPlayers(playerList);
        validPlayers(playerList);
        this.players = playerList;
    }

    public static Players of(List<String> nameList) {
        return new Players(nameList.stream()
                .map(name -> Player.of(name))
                .collect(toCollection(ArrayList::new)));
    }

    private void validPlayers(List<Player> playerList) {
        Set<Name> names = new HashSet<>();
        playerList.forEach(player -> player.addName(names));
        if (names.size() != playerList.size()) {
            throw new IllegalArgumentException(ILLEGAL_DUPLICATE_NAME);
        }
    }

    private void emptyPlayers(List<Player> playerList) {
        if (playerList == null || playerList.isEmpty() || playerList.size() == 0) {
            throw new IllegalArgumentException(ILLEGAL_EMPTY_PLAYER);
        }
    }

    public void match(List<Result> resultList, Map<Player, Result> winning) {
        Streams.forEachPair(players.stream(), resultList.stream(),
                (player, result) -> winning.put(player, result)
        );
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
