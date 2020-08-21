package ladder.domain;

import java.util.function.Consumer;

public class RandomDrawStrategy implements DrawStrategy {

    private boolean beforeDraw;

    @Override
    public void draw(int index, Consumer<Integer> indexConsumer) {
        if (!beforeDraw && Math.random() > 0.5) {
            indexConsumer.accept(index);
            beforeDraw = true;
            return;
        }
        beforeDraw = false;
    }
}
