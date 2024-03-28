package ladder2.controller;

import ladder2.domain.Ladder;
import ladder2.domain.Players;
import ladder2.domain.Prizes;
import ladder2.domain.factory.LadderFactory;
import ladder2.domain.LadderJudge;
import ladder2.view.InputView;
import ladder2.view.OutputView;

public class LadderConsole {

    private static final String WHOLE_PLAYER = "all";

    private final InputView inputView;
    private final OutputView outputView;

    public LadderConsole(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        Players players = inputView.inputPlayers();
        Prizes prizes = inputView.inputPrizes();
        int height = inputView.inputHeight();

        Ladder ladder = LadderFactory.generate(height, players.count());
        outputView.printLadder(ladder, players, prizes);

        LadderJudge judge = new LadderJudge(players, prizes);
        judge.judge(ladder.result());
        checkGameResult(players);
    }

    private void checkGameResult(Players players) {
        String playerName = inputView.inputPlayerNameToCheck();
        if (WHOLE_PLAYER.equals(playerName)) {
            outputView.printPrize(players);
            return;
        }
        outputView.printPrize(players.getByName(playerName));

        checkGameResult(players);
    }
}
