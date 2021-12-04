package ladder.model.stringas;

import ladder.model.Player;

import java.util.List;
import java.util.stream.Collectors;

public class StringAsPlayers {

    private final StringAsNames stringAsNames;

    public StringAsPlayers(String players) {
        stringAsNames = new StringAsNames(players);
    }

    public List<Player> get() {
        return stringAsNames.get().stream()
                .map(Player::new)
                .collect(Collectors.toList());
    }
}
