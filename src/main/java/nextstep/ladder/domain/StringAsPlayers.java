package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StringAsPlayers extends AbstractInput {

    public StringAsPlayers(String players) {
        super(players);
    }

    public Players players() {
        List<Name> players = getStream()
            .map(StringFactory::name)
            .collect(Collectors.toCollection(ArrayList::new));
        return new Players(players);
    }

}
