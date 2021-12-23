package nextstep.ladder.domain.ladder.strategy;

import java.util.List;

@FunctionalInterface
public interface Strategy {
    List<Boolean> points(int numberOfParticipants);
}
