package game.ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class GameResultCache {

    private final Ladder ladder;
    private final Map<Name, GameResults> cache;

    public GameResultCache(Ladder ladder) {
        this.ladder = ladder;
        this.cache = new HashMap<>();
    }

    public GameResults getGameResults(Name name) {
        return this.cache.computeIfAbsent(name, this.ladder::makeGameResults);
    }

}
