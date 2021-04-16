package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Prizes {
    private final List<Prize> prizes;

    public Prizes(List<String> prizeNames) {
        prizes = new ArrayList<>();
        prizeNames.stream()
                .map(Prize::new)
                .forEach(prizes::add);
    }

    public Prize givePrizeTo(Player player) {
        return null;
    }
}
