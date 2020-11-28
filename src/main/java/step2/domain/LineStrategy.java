package step2.domain;

import java.util.List;

@FunctionalInterface
public interface LineStrategy {

    List<Boolean> createLine(int personCount);
}
