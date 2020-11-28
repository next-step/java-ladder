package step2.domain;

import java.util.List;

@FunctionalInterface
public interface LineStrategy {

    List<LadderPoint> createLine(int personCount);
}
