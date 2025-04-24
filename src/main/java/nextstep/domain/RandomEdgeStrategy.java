package nextstep.domain;

import java.util.Random;

/**
 * 랜덤으로 라인 잡아줄 경우
 */
public class RandomEdgeStrategy implements EdgeStrategy {
    private static final Random RANDOM = new Random();

    @Override
    public boolean generate(int index, boolean connected) {
        return !connected && RANDOM.nextBoolean();
    }
}
