package nextstep.ladder.domain;

import java.util.Random;

// NOTE : java.util.Random 다수 인스턴스 생성을 통한 성능 저하를 막기 위한 싱글톤
public enum RandomWrapper implements RandomValueGenerator {

    INSTANCE;

    private static final Random random = new Random();

    private static void updateSeed() {
        random.setSeed(System.nanoTime());
    }

    public static RandomWrapper getInstance() {
        return INSTANCE;
    }

    @Override
    public boolean nextValue() {
        updateSeed();
        return random.nextBoolean();
    }
}