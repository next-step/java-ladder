package ladder.domain.nextstep;

import ladder.domain.nextstep.Player;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private static final int MIN_NUMBER_OF_PLAYERS = 2;
    private static final String MESSAGE_MIN_NUMBER_OF_PLAYERS = "참여자는 2명 이상이어야 합니다.";
    private List<Player> players;

    public Players(String[] players){
        validate(players);
        this.players = Arrays.stream(players)
                            .map(Player::new)
                            .collect(Collectors.toList());
    }

    private void validate(String[] players) {
        if (players.length < MIN_NUMBER_OF_PLAYERS) {
            throw new IllegalArgumentException(MESSAGE_MIN_NUMBER_OF_PLAYERS);
        }
    }

    public int numberOfPlayer(){
        return players.size();
    }

    public List<Player> players(){
        return Collections.unmodifiableList(players);
    }
}
