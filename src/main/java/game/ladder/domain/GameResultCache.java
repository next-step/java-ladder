package game.ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class GameResultCache {

    private final Ladder ladder;
    private final Map<Name, GameResults> cache2;

    public GameResultCache(Ladder ladder) {
        this.ladder = ladder;
        this.cache2 = new HashMap<>();
    }

    public GameResults getGameResults2(Name name) {
        return this.cache2.computeIfAbsent(name, this.ladder::makeGameResults);
    }

}
