package ladder.domain;

import java.util.ArrayList;
import java.util.List;

import static ladder.util.RandomUtil.getRandomBoolean;

public class Ladder {
    private static final String FALSE_POINT = "     |";
    private static final String TRUE_POINT = "-----|";
    private static final int ZERO = 0;

    private final StringBuilder sb = new StringBuilder();

    private final List<Boolean> ladder;

    public Ladder(int nameSize) {
        ladder = new ArrayList<>();

        for (int i = 0; i < nameSize - 1; i++) {
            this.ladder.add(isBeforeFalse(getRandomBoolean()));
        }
    }

    public Ladder(List<Boolean> defaultLadder) {
        this.ladder = defaultLadder;
    }

    public String ladderDraw() {
        sb.setLength(ZERO);
        sb.append(FALSE_POINT);

        this.ladder.forEach(point -> {
            if (point) {
                sb.append(TRUE_POINT);
            }
            if (!point) {
                sb.append(FALSE_POINT);
            }
        });

        return sb.toString();
    }

    private boolean isBeforeFalse(boolean flag) {
        if (!this.ladder.isEmpty() && this.ladder.get(this.ladder.size() - 1)) {
            flag = false;
        }

        return flag;
    }
}
