package nextstep.ladder.view;

import nextstep.ladder.model.LadderStatus;

@FunctionalInterface
public interface OutputView {
    LadderStatus printLadderStatus(LadderStatus status);
}
