package camp.nextstep.edu.rebellion.refactoring;

import camp.nextstep.edu.rebellion.domain.rule.AlwaysDrawingRule;
import camp.nextstep.edu.rebellion.domain.rule.DrawingRule;

public class LadderPointGenerator {
    public static boolean generatePoint() {
        return generatePoint(new AlwaysDrawingRule());
    }

    public static boolean generatePoint(DrawingRule rule) {
        return rule.canDraw();
    }
}
