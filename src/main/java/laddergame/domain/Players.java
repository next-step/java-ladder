package laddergame.domain;

import java.util.List;

import static java.util.stream.Collectors.joining;

public class Players {
    private final List<Player> players;

    public Players(List<Player> players) {
        if(players.size() < 2){
            throw new IllegalArgumentException("사다리 게임의 플레이어는 최소 2명 이상이어야 합니다");
        }
        this.players = players;
    }

    public int size(){
        return players.size();
    }

    @Override
    public String toString() {
        return players.stream()
                .map(Player::toString)
                .collect(joining("   "));
    }
}
