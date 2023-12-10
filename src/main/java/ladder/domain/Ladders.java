package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladders {
    private final List<Ladder> ladders;

    public Ladders(int playerSize, int height) {
        ladders = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            this.ladders.add(new Ladder(playerSize));
        }
    }

    public List<Ladder> getLadders() {
        return this.ladders;
    }
}
