package laddergame.v2.domain;

import java.util.ArrayList;
import java.util.List;

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

    public List<Player> getPlayers() {
        return new ArrayList<>(players);
    }
}
