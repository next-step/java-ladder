package laddergame.domain.linepainter;

import java.util.*;

public class RandomLinePainter implements LinePainter {

    private static final Random RANDOM = new Random();

    @Override
    public List<Boolean> draw(int count) {
        List<Boolean> booleans = makeDefaultLine();

        for (int i = 1; i < count; i++) {
            booleans.add(i, makePoint(booleans.get(i - 1)));
        }

        return Collections.unmodifiableList(booleans);

    }

    private static List<Boolean> makeDefaultLine() {
        ArrayList<Boolean> booleans = new ArrayList<>();
        booleans.add(false);
        return booleans;
    }

    private Boolean makePoint(Boolean before) {
        if (before) {
            return false;
        }
        return RANDOM.nextBoolean();
    }
}
