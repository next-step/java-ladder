package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class VerticalLadder {

    private final List<Boolean> lines;

    public VerticalLadder(int personCount) {
        List<Boolean> value = init(personCount);
        this.lines = value;
    }

    private List<Boolean> init(int personCount) {
        List<Boolean> result = new ArrayList<>(personCount);
        for (int i = 0; i < personCount; i++) {
            result.add(true);
        }

        return result;
    }

    public int size() {
        return lines.size();
    }
}
