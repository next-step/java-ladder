package domain;

import java.util.Collections;
import java.util.List;

public class Ladders {

    private final List<Ladder> ladders;

    public Ladders(List<Ladder> ladders) {
        this.ladders = Collections.unmodifiableList(ladders);
    }

    public int height() {
        return this.ladders.size();
    }

    public List<Ladder> getLadders() {
        return ladders;
    }

    public int move(int index) {
        for (Ladder ladder : this.ladders) {
            index += ladder.nextDirection(index);
        }
        return index;
    }
}
