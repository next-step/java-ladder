package ladder;

import ladder.domain.LadderGame;
import ladder.domain.dto.LadderShapeResult;
import ladder.domain.ladder.Height;
import ladder.domain.ladder.shape.LadderShapeInfo;
import ladder.domain.player.Players;
import ladder.domain.prize.Prizes;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderApplication {

    public static void main(String[] args) {
        Players players = Players.of(InputView.inputPlayers());
        Prizes prizes = Prizes.of(InputView.inputPrizes());
        Height height = Height.of(InputView.inputHeight());
        LadderShapeInfo ladderShapeInfo = LadderShapeInfo.valueOf(players, height);

        LadderShapeResult result = LadderGame.of(ladderShapeInfo).play();

        String targetPlayerNames = InputView.inputTargetPlayers();

        ResultView.printResult(result);
    }
}
