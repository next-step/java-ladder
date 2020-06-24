package nextstep.step3.domain.strategy;

import java.util.List;

@FunctionalInterface
public interface DrawLineStrategy {
    boolean isDrawLine(List<Boolean> points, int idx);
}
