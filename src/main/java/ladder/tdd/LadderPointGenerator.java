package ladder.tdd;

import ladder.domain.rule.DrawRule;
import ladder.domain.rule.RandomDrawRule;

public class LadderPointGenerator {
    public static boolean generatePoint() {
        return generatePoint(new RandomDrawRule());
    }

    public static boolean generatePoint(DrawRule rule) {
        return rule.isDrawable();
    }
}
