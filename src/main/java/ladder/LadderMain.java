package ladder;

import ladder.domain.LadderGame;
import ladder.view.InputView;

public class LadderMain {
    public static void main(String[] args) {
        final String usersExpression = InputView.plzEnterUserNames();
        final int ladderHeight = InputView.plzEnterLadderHeight();
        
        final LadderGame ladderGame = LadderGame.of(usersExpression, ladderHeight);
    }
}
