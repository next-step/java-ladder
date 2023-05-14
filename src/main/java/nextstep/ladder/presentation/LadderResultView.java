package nextstep.ladder.presentation;

import nextstep.ladder.domain.Ladder;

public class LadderResultView {
    private final Ladder ladder;

    public LadderResultView(Ladder ladder) {
        this.ladder = ladder;
    }

    public void printLadder() {
        ladder.lines().stream()
                .map(LineResultView::new)
                .forEach(LineResultView::printLine);
    }
}
