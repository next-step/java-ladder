package ladder.domain;

import java.util.ArrayList;
import java.util.List;

import static ladder.util.RandomUtil.getRandomBoolean;

public class Ladder {
    private final String FALSE_POINT = "     |";
    private final String TRUE_POINT = "-----|";

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
        StringBuilder sb = new StringBuilder();

        sb.append(FALSE_POINT);

        this.ladder.forEach(x -> {
            if (x) {
                sb.append(TRUE_POINT);
            }
            if (!x) {
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
