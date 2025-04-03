package ladder.domain;

import java.util.List;

public class LadderFactory {
    private final Names names;
    private final Ladders ladders;

    public LadderFactory(String namesText, int height) {
        this(namesText, height, new RandomLineGenerator());
    }

    public LadderFactory(String namesText, int height, LineGenerator lineGenerator) {
        this.names = new Names(namesText);
        this.ladders = new Ladders(height, names.connectSize(), lineGenerator);
    }

    public List<List<Boolean>> getLadder() {
        return ladders.getAll();
    }

    public List<String> getNames() {
        return names.getAll();
    }
}
