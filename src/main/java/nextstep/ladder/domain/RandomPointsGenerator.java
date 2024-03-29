package nextstep.ladder.domain;

import java.util.List;
import java.util.Random;
import java.util.function.BooleanSupplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomPointsGenerator {

    private static final Random RANDOM = new Random();

    public static List<Boolean> generate(int pointSize) {
        return Stream.generate(PointSupplier::getInstance)
                .map(BooleanSupplier::getAsBoolean)
                .limit(pointSize)
                .collect(Collectors.toUnmodifiableList());
    }

    private static class PointSupplier implements BooleanSupplier {
        private static final PointSupplier INSTANCE = new PointSupplier();
        private boolean previous;

        public static PointSupplier getInstance() {
            return INSTANCE;
        }

        private PointSupplier() {
            this.previous = RANDOM.nextBoolean();
        }

        @Override
        public boolean getAsBoolean() {
            if (previous) {
                previous = false;
                return false;
            }
            boolean current = RANDOM.nextBoolean();
            previous = current;
            return current;
        }
    }

}
