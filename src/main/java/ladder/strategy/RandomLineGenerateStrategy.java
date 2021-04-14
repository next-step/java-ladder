package ladder.strategy;

import java.util.Random;

// 무상태성을 이용해 코드를 작성했는데 인스턴스 필드를 만드는 것이 좋을까요?
public final class RandomLineGenerateStrategy implements LineGenerateStrategy {

    private static final class RandomLineGenerateStrategyHolder {
        private static final RandomLineGenerateStrategy instance = new RandomLineGenerateStrategy();
    }

    public static final RandomLineGenerateStrategy getInstance() {
        return RandomLineGenerateStrategyHolder.instance;
    }

    @Override
    public boolean generateLine() {
        return new Random().nextBoolean();
    }
}
