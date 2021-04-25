/*
 * 사다리타기 게임 참여자목록을 담당하는 클래스
 * */
package step4.laddergame.domain.player;

import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toCollection;

public class Players {
    private static final String ILLEGAL_DUPLICATE_NAME = "참여자의 이름은 중복될 수 없습니다.";
    private static final String ILLEGAL_EMPTY_PLAYER = "참여자는 한 명 이상이어야합니다.";
    private static final String ILLEGAL_FIND_NAME = "결과를 보고싶은 사람의 이름이 목록에는 없습니다.";

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

    public int whoseName(Name findName) {
        return IntStream.range(0, players.size())
                .filter(i -> players.get(i).checkName(findName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ILLEGAL_FIND_NAME));
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

    public int getNumber() {
        return players.size();
    }

    public Player getOne(int index) {
        return players.get(index);
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
