package ladder.game;

import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Prizes {
    private final List<Prize> prizes;

    public Prizes(List<String> inputResults) {
        this.prizes = inputResults.stream().map(Prize::new).collect(toList());
    }

    public List<Prize> values() {
        return Collections.unmodifiableList(prizes);
    }

    public int size() {
        return prizes.size();
    }
}
