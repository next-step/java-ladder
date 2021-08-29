package nextstep.ladder.domain;

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
