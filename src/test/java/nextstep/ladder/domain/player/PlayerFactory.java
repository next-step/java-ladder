package nextstep.ladder.domain.player;

import nextstep.ladder.domain.player.Name;
import nextstep.ladder.domain.player.Players;
import java.util.ArrayList;
import java.util.List;

public class PlayerFactory {

    public static Players playerFixture(String... names) {
        List<Name> gamers = new ArrayList<>();

        for (String name : names) {
            gamers.add(Name.of(name));
        }

        return Players.from(gamers);
    }

}
