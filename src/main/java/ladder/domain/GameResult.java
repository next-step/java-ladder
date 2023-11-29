package ladder.domain;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

public class GameResult {
    private final Map<Name, Gift> results;

    private GameResult(Map<Name, Gift> results) {
        this.results = results;
    }

    public static GameResult valueOf(People people, LadderLines ladderLines, Gifts gifts) {
        return new GameResult(
                people.values().stream()
                        .collect(Collectors.toMap(
                                name -> name,
                                name -> gifts.find(ladderLines.move(people.indexOf(name))))
                        ));
    }

    public Gift checkResult(Name name) {
        return results.get(name);
    }

    public Map<Name, Gift> values() {
        return Collections.unmodifiableMap(results);
    }
}
