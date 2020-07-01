package ladder;

import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.Users;
import ladder.ui.OutputView;

public class LadderController {

    public void drawLadderGame(Height height, Users users){
        Ladder ladder = new Ladder(height.getHeight(),users.getUserCount());
        OutputView.drawLadder(ladder, users);
    }
}
