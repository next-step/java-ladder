package ladder;

import ladder.domain.LadderGame2;
import ladder.domain.PlayersAndPrizes;
import ladder.domain.dto.LadderMatchResult;
import ladder.domain.dto.LadderShapeResult2;
import ladder.domain.ladder.shape.Height;
import ladder.domain.ladder.shape.LadderShapeInfo2;
import ladder.domain.player.Players;
import ladder.domain.prize.Prizes;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderApplication {

    public static void main(String[] args) {

        Players players = Players.of(InputView.inputPlayers());
        Prizes prizes = Prizes.of(InputView.inputPrizes());
        PlayersAndPrizes playersAndPrizes = PlayersAndPrizes.valueOf(players, prizes);
        Height height = Height.of(InputView.inputHeight());

        LadderShapeInfo2 ladderShapeInfo = LadderShapeInfo2.valueOf(playersAndPrizes, height);
        LadderGame2 ladderGame = LadderGame2.of(ladderShapeInfo);

        LadderShapeResult2 ladderShapeResult = ladderGame.ready();
        ResultView.printLadderShape(ladderShapeResult);

        LadderMatchResult ladderMatchResult = ladderGame.play();
        while (true) {
            String targetPlayerName = InputView.inputTargetPlayers();
            ResultView.printResult(ladderMatchResult, targetPlayerName);
        }
    }
}
