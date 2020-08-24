package camp.nextstep.edu.rebellion.domain.rule;

import java.util.Random;

public class RandomDrawingRule implements DrawingRule {
    private final Random RANDOM = new Random();
    private final int DRAWING_RATE = 50;

    @Override
    public boolean canDraw() {
        return  RANDOM.nextInt(100) < DRAWING_RATE;
    }
}
