package ladder.controller;

import ladder.domain.Rewards;
import ladder.view.InputView;
import ladder.view.ResultView;
import ladder.domain.ladder.Ladder;
import ladder.domain.player.Players;

public class LadderGame {

    public void start(){
        Players players = new Players(InputView.inputPlayerNames());

        Rewards rewards = new Rewards(InputView.inputResultValue(), players.getPlayerNum());

        int ladderHeight = InputView.inputLadderHeight();

        Ladder ladder = Ladder.createLadder(players.getPlayerNum(), ladderHeight);

        ResultView.showLadderResult(players, ladder, rewards);

        String resultPlayer = InputView.inputResultPlayer();
        //players.isValidPlayer(resultPlayer);

        int ladderPosition = players.getPositionInLadder(resultPlayer);
    }
}
