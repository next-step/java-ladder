package ladder.domain;

import java.util.Collections;
import java.util.Map;

public class Winning {
    private final Map<Name, Prize> winning;

    public Winning(Map<Name, Prize> winning) {
        this.winning = winning;
    }

    public Prize prize(Name key) {
        return winning.get(key);
    }

    public Map<Name, Prize> playerByPrize() {
        return Collections.unmodifiableMap(winning);
    }

    public int size(){
        return winning.size();
    }
}
