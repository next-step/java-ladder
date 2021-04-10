package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.LineNumber;
import ladder.domain.MatchResult;
import ladder.domain.Player;
import ladder.domain.Players;
import ladder.domain.Prizes;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderController {
    private static final String ALL = "ALL";

    public LadderController() {
    }

    public void run() {
        Players players = new Players(InputView.inputPlayerNames());
        Prizes prizes = new Prizes(InputView.inputResultPrizes(), players.playerCount());
        Ladder ladder = new Ladder(players.playerCount(), InputView.inputMaxLadderHeight());

        ResultView.printPlayerNames(players);
        ResultView.printLadder(ladder);

        MatchResult matchResult = new MatchResult();
        players.getPlayers().forEach(player -> {
            LineNumber matchLineNumber = ladder.matchResult(player.getLineNumber());
            matchResult.addMatchResult(player, prizes.matchNumber(matchLineNumber));
        });


        String prizeOfPlayer = InputView.inputPrizeOfPlayer();
        while (!ALL.equals(prizeOfPlayer)) {
            ResultView.printMatchOfPrize(matchResult.matchPlayer(players.findPlayer(prizeOfPlayer)));
            prizeOfPlayer = InputView.inputPrizeOfPlayer();
        }
        ResultView.printAllMatchOfPrize(matchResult);
    }
}
