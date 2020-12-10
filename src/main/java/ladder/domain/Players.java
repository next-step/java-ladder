package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Players {

    private static final int FIRST_INDEX = 0;
    private List<Player> players;

    public Players(String[] players){
        this.players = Arrays.stream(players)
                .map(Player::from)
                .collect(Collectors.toList());
    }

    public List<Player> getPlayers() {
        return players;
    }


    public Player searchPlayerName(int index) {
        validatePlayerIndex(index);
        return players.get(index);
    }

    private void validatePlayerIndex(int index) {
        if(index < FIRST_INDEX || index >= players.size()){
            throw new IllegalArgumentException("해당 위치에 참여한 사람값이 존재하지 않습니다.");
        }

    }

}
