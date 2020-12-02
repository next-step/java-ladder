package nextstep.ladder.domain;

import java.util.Map;

public class Matches {

    private final Map<Player, Result> matches;

    public Matches(Map<Player, Result> matches) {
        this.matches = matches;
    }

    public Result find(String nameToFind) {
        Player playerFound = matches.keySet()
                .stream()
                .filter(player -> player.getName().equals(nameToFind))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("there's no player of that name"));

        return matches.get(playerFound);
    }
}
