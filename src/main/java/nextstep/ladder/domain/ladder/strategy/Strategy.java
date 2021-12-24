package nextstep.ladder.domain.ladder.strategy;

import java.util.Arrays;
import java.util.List;

@FunctionalInterface
public interface Strategy {
    List<Boolean> points(int numberOfParticipants);

    final class Fake implements Strategy {
        @Override
        public List<Boolean> points(int numberOfParticipants) {
            return Arrays.asList(true, false, true);
        }
    }
}
