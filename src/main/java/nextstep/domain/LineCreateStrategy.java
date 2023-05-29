package nextstep.domain;

import java.util.List;

public interface LineCreateStrategy {

    List<Point> create(int peopleCount);
}
