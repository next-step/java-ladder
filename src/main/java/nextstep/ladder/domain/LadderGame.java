package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {

    public static Ladders newInstance(int size, int height) {
        List<Ladder> ladders = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            ladders.add(new Ladder());
        }
        return new Ladders(ladders, height);
    }
}
