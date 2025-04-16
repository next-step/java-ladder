package nextstep.ladder.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Prize {
    private final Map<Name, LadderResult> prize;

    public Prize(List<Player> players, List<LadderResult> ladderResult) {
        this.prize = players.stream()
                .collect(Collectors.toMap(Player::getName, player -> player.matchResult(ladderResult)));
    }

    public Map<Name, LadderResult> getPrize(Name name) {
        if (name.equals(new Name("all"))) {
            return new HashMap<>(prize);
        }

        if (prize.containsKey(name)) {
            return Map.of(name, prize.get(name));
        }

        throw new IllegalArgumentException("Invalid viewer name");
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Prize prize1 = (Prize) o;
        return Objects.equals(prize, prize1.prize);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(prize);
    }
}
