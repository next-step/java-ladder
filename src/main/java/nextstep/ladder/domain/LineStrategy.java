package nextstep.ladder.domain;

import java.util.List;

@FunctionalInterface
public interface LineStrategy {
    List<Boolean> generate(int n);
}
