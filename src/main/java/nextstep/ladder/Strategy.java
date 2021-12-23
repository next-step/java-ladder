package nextstep.ladder;

import java.util.List;

@FunctionalInterface
public interface Strategy {
    List<Boolean> points(int numberOfParticipants);
}
