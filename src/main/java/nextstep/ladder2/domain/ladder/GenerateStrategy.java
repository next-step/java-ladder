package nextstep.ladder2.domain.ladder;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.BooleanSupplier;

public class GenerateStrategy {
    public static BooleanSupplier randomBooleanSupplier = () -> { return ThreadLocalRandom.current().nextBoolean();};

    public static BooleanSupplier trueSupplier = () -> { return true; };
}
