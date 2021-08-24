package nextstep.ladder.step2.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private static final String DELIMITER = ",";
    private List<Name> players;

    public Player(String inputPlayers) {
        this(toArray(inputPlayers));
    }

    public static String[] toArray(String inputPlayers) {
        return inputPlayers.split(DELIMITER);
    }

    public Player(String[] players) {
        this.players = new ArrayList<>();
        for (String player : players) {
            this.players.add(new Name(player));
        }
    }
}
