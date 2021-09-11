package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {
    private static final int FIRST_INDEX = 0;
    private static final int SECOND_INDEX = 1;

    private final List<Ladder> ladders;

    public LadderGame(List<String> names, int height) {
        ladders = new ArrayList<>();
        ladders.add(new Ladder(names.get(FIRST_INDEX), height));

        for (int i = SECOND_INDEX; i < names.size(); i++) {
            ladders.add(new Ladder(names.get(i), ladders.get(i - 1)));
        }
    }

    public List<Ladder> ladders() {
        return new ArrayList<>(this.ladders);
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
