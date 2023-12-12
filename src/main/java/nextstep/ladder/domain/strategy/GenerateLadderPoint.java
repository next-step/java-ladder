package nextstep.ladder.domain.strategy;

import java.util.List;

@FunctionalInterface
public interface GenerateLadderPoint {
    List<Boolean> generate(int size);
}
