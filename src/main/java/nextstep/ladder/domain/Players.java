package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private static final int NAME_PRINT_LENGTH = 7;
    private static final String BLANK = " ";
    private final List<Player> players;

    public Players(List<Player> players) {
        checkPlayersSize(players);
        this.players = players;
    }

    public Players(String... players) {
        this(Arrays.stream(players).map(Player::of).collect(Collectors.toList()));
    }

    private void checkPlayersSize(List<Player> players) {
        if (players.size() <= 1) {
            throw new IllegalArgumentException("참여자는 2명 이상으로 설정 하세요");
        }
    }

    public int numberOfPlayers() {
        return players.size();
    }

    public int indexOf(String name) {
        int index = players.indexOf(Player.of(name));

        if (index < 0) {
            throw new IllegalArgumentException("찾으시는 참여자가 없습니다.");
        }

        return index;
    }

    public Player getPlayer(int index) {
        return players.get(index);
    }

    @Override
    public String toString() {
        return this.players.stream()
                .map(this::nameForPrint)
                .collect(Collectors.joining(""));
    }

    private String nameForPrint(Player player) {
        String name = player.toString();

        return BLANK.repeat(NAME_PRINT_LENGTH - name.length()) + name;
    }
}