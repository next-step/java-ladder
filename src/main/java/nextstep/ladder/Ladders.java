package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;

public class Ladders {
    private List<Ladder> ladders;

    public Ladders(int size, int height) {
        ladders = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            ladders.add(new Ladder(height));
        }
    }

    public int size() {
        return ladders.size();
    }
}
