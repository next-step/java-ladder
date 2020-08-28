package camp.nextstep.edu.rebellion.game.origin;

import camp.nextstep.edu.rebellion.domain.rule.DrawingRule;
import camp.nextstep.edu.rebellion.domain.rule.RandomDrawingRule;

public class LadderPointGenerator {
    public static boolean generatePoint() {
        return generatePoint(new RandomDrawingRule());
    }

    public static boolean generatePoint(DrawingRule rule) {
        return rule.canDraw();
    }
}
