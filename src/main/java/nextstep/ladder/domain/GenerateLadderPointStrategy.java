package nextstep.ladder.domain;

import java.util.List;

@FunctionalInterface
public interface GenerateLadderPointStrategy {
    List<Boolean> generate(int size);
}
