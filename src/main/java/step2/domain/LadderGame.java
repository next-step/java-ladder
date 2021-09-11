package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {
    private final List<Ladder> ladders;

    public LadderGame(List<String> names, int height) {
        ladders = new ArrayList<>();
        for (int i = 0; i < names.size(); i++) {
            if (i == 0) {
                ladders.add(new Ladder(names.get(i), height));
            } else {
                ladders.add(new Ladder(names.get(i), ladders.get(i - 1)));
            }
        }
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Ladder ladder : ladders) {
            sb.append(ladder);
        }
        return sb.toString();
    }
}
