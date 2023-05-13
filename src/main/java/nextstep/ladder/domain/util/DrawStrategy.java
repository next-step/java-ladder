package nextstep.ladder.domain.util;

import nextstep.ladder.domain.Step;

public interface DrawStrategy {

    boolean drawFirstPosition();

    boolean drawNextPosition(Step step);
}
