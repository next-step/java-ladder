package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderGameResult;
import nextstep.ladder.domain.Players;
import nextstep.ladder.domain.WinningItems;

public class LadderView {

    private final LadderInputView ladderInputView;

    private final LadderOutputView ladderOutputView;

    public LadderView(LadderInputView ladderInputView, LadderOutputView ladderOutputView) {
        this.ladderInputView = ladderInputView;
        this.ladderOutputView = ladderOutputView;
    }

    public Players playersNameInput() {
        return ladderInputView.playersNameInput();
    }

    public int ladderHeightInput() {
        return ladderInputView.ladderHeightInput();
    }

    public void ladderOutput(Ladder ladder, WinningItems winningItems) {
        ladderOutputView.ladderOutput(ladder, winningItems);
    }

    public WinningItems winningItemNameInput(int countOfPlayers) {
        return ladderInputView.winningItemNameInput(countOfPlayers);
    }

    public String gameResultPlayerInput() {
        return ladderInputView.gameResultPlayerInput();
    }

    public void ladderGameOutPut(LadderGameResult ladderGameResult) {
        ladderOutputView.ladderGameOutPut(ladderGameResult);
    }
}
