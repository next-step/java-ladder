package nextstep.ladder;

import nextstep.ladder.domain.*;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderGame {

    public static void main(String[] args) {

        Players players = new Players(InputView.inputNames());
        int ladderHeight = InputView.inputLadderHeight();
        LadderResults ladderResults = new LadderResults(InputView.inputLadderResults());

        Ladder ladder = new Ladder(LadderGenerateFactory.findGenerator(), players.numberOfPlayers(), ladderHeight);
        LadderPlay ladderPlay = LadderPlay.of(players, ladder);

        ResultView.printResult(players, ladder);
        ResultView.printLadderResult(ladderResults.getLadderResults());
        GameResults gameResults = ladderPlay.climbLadder(ladderResults);
        String playerName = InputView.inputWhoWantCheckResult();

        while (!playerName.equals(ResultView.ALL_RESULTS)) {
            playerName = InputView.inputWhoWantCheckResult();
            ResultView.printPlayersResults(playerName, gameResults);
        }
    }
}
