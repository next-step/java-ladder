package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static ladder.domain.LadderGameConfig.FIRST_INDEX;

public class Players {

    private List<Player> players;

    public Players(String[] players){
        this.players = Arrays.stream(players)
                .map(Player::new)
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
            throw new IllegalArgumentException(LadderGameErrorMessage.ILLEGAL_PLAYER_INDEX.getErrorMessage());
        }

    }

}
