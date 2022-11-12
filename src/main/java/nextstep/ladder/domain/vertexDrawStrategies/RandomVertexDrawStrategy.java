package nextstep.ladder.domain.vertexDrawStrategies;

import java.util.Random;

public class RandomVertexDrawStrategy implements VertexDrawStrategy {
    private final Random random = new Random();

    public boolean shouldDraw() {
        return random.nextBoolean();
    }
}
