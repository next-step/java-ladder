package nextstep.ladder.controller;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Players;
import nextstep.ladder.view.LadderView;

public class LadderController {

    private final LadderView ladderView;

    public LadderController(LadderView ladderView) {
        this.ladderView = ladderView;
    }

    public Players ladderGamePlayers(){
        return ladderView.playersNameInput();
    }

    public void createLadder(Players players){
        int ladderHeight = ladderView.ladderHeightInput();

        Ladder ladder = new Ladder(ladderHeight, players);

        ladderView.ladderOutput(ladder);
    }
}
