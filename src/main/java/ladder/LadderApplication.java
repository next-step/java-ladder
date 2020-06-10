package ladder;

import ladder.domain.LadderGame;
import ladder.domain.LadderGame2;
import ladder.domain.dto.LadderMatchResult;
import ladder.domain.dto.LadderShapeResult;
import ladder.domain.PlayersAndPrizes;
import ladder.domain.dto.LadderShapeResult2;
import ladder.domain.ladder.shape.Height;
import ladder.domain.ladder.shape.LadderShapeInfo;
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

//        LadderShapeInfo ladderShapeInfo = LadderShapeInfo.valueOf(players, prizes, height);
        LadderShapeInfo2 ladderShapeInfo = LadderShapeInfo2.valueOf(playersAndPrizes, height);

//        LadderGame ladderGame = LadderGame.of(ladderShapeInfo);
        LadderGame2 ladderGame = LadderGame2.of(ladderShapeInfo);

        LadderShapeResult ladderShapeResult = ladderGame.ready();
//        LadderShapeResult2 ladderShapeResult = ladderGame.ready();

        ResultView.printLadderShape(ladderShapeResult);
//        ResultView.printLadderShape2(ladderShapeResult);

        LadderMatchResult ladderMatchResult = ladderGame.play();
        while (true) {
            String targetPlayerName = InputView.inputTargetPlayers();
            ResultView.printResult(ladderMatchResult, targetPlayerName);
        }
    }
}
