package ladder.domain;

import java.util.function.Consumer;

public class RandomDrawStrategy implements DrawStrategy {

    private static final double DRAW_PROBABILITY = 0.5;

    private boolean beforeDraw;

    @Override
    public void draw(int index, Consumer<Integer> indexConsumer) {
        if (!beforeDraw && Math.random() > DRAW_PROBABILITY) {
            indexConsumer.accept(index);
            beforeDraw = true;
            return;
        }
        beforeDraw = false;
    }
}
