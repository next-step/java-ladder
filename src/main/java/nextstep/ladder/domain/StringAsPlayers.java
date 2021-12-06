package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import nextstep.ladder.exception.NameNullPointerException;

public class StringAsPlayers {

    private static final String DELIMITER = ",";

    private final String players;

    public StringAsPlayers(String players) {
        valid(players);
        this.players = players;
    }

    private void valid(String players) {
        if (players == null || players.isEmpty()) {
            throw new NameNullPointerException();
        }
    }

    public Players players() {
        List<Name> players = Arrays
            .stream(this.players.split(DELIMITER))
            .map(Name::from)
            .collect(Collectors.toCollection(ArrayList::new));
        return new Players(players);
    }

}
