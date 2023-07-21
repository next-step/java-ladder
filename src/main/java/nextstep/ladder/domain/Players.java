package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    public final List<Player> players;

    public Players(List<Player> players) {
        checkPlayersSize(players);
        this.players = players;
    }

    public Players(String[] players) {
        this.players = Arrays.stream(players).map(Player::new).collect(Collectors.toList());
    }

    public int numberOfPlayers(){
        return players.size();
    }

    private void checkPlayersSize(List<Player> players) {
        if (players.size() <= 1) {
            throw new IllegalArgumentException("참여자는 2명 이상으로 설정 하세요");
        }
    }

    @Override
    public String toString() {
        return String.join("", this.players.stream()
                .map(Player::toString)
                .collect(Collectors.toList()));
    }
}