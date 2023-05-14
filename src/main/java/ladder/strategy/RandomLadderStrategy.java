package ladder.strategy;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.BooleanSupplier;

public class RandomLadderStrategy implements LadderStrategy {

    private final BooleanSupplier randomSupplier;

    public RandomLadderStrategy() {
        this(ThreadLocalRandom.current()::nextBoolean);
    }

    public RandomLadderStrategy(ThreadLocalRandom random) {
        this(random::nextBoolean);
    }

    public RandomLadderStrategy(BooleanSupplier randomSupplier) {
        this.randomSupplier = Objects.requireNonNull(randomSupplier, "랜덤 전략 생성자에 null 을 전달 할 수 없습니다");
    }

    @Override
    public boolean firstLine() {
        return randomSupplier.getAsBoolean();
    }

    @Override
    public boolean nextLine(boolean previousLine) {
        return isPossibleGenerateNextLine(previousLine) && generateRandomLine();
    }

    private boolean isPossibleGenerateNextLine(boolean previousLine) {
        return !previousLine;
    }

    private boolean generateRandomLine() {
        return randomSupplier.getAsBoolean();
    }
}

