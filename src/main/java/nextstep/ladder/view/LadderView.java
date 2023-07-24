package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Players;

public class LadderView {

    private final LadderInputView ladderInputView;

    private final LadderOutputView ladderOutputView;

    public LadderView(LadderInputView ladderInputView, LadderOutputView ladderOutputView) {
        this.ladderInputView = ladderInputView;
        this.ladderOutputView = ladderOutputView;
    }

    public Players playersNameInput(){
        return ladderInputView.playersNameInput();
    }

    public int ladderHeightInput() {
        return ladderInputView.ladderHeightInput();
    }

    public void ladderOutput(Ladder ladder) {
        ladderOutputView.ladderOutput(ladder);
    }
}
