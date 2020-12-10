package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<String> value;

    public Ladder(int personCount) {
        TransverseLadder transverseLadder = new TransverseLadder(personCount);
        VerticalLadder verticalLadder = new VerticalLadder(personCount);

        int size = transverseLadder.size() + verticalLadder.size();

        List<String> result = new ArrayList<>(size);
        int index = 0;
        for (int i = 0; i < size; i++) {

            if (i % 2 == 0) {
                result.add("|");
                continue;
            }

            if (Boolean.TRUE.equals(transverseLadder.getPoints().get(index))) {
                result.add("------");
            }

            if (Boolean.FALSE.equals(transverseLadder.getPoints().get(index))) {
                result.add("      ");
            }

            index++;

        }

        value = result;

    }

    public List<String> getValue() {
        return value;
    }
}
