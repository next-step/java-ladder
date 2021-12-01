package ladder.model;

import java.util.List;
import java.util.stream.Collectors;

public class StringAsPlayers implements Players {

    private final StringAsNames stringAsNames;

    public StringAsPlayers(String players) {
        stringAsNames = new StringAsNames(players);
    }

    @Override
    public List<Player> players() {
        return stringAsNames.names().stream()
                .map(Player::new)
                .collect(Collectors.toList());
    }
}
