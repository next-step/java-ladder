package nextstep.ladder.domain.strategy;

import nextstep.ladder.domain.Point;

public interface CreateStrategy {
    boolean isCreate(Point beforePoint);

    boolean generate();
}
