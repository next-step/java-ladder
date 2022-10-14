package ladder;

import ladder.domain.Ladder;
import ladder.domain.line.v2.RandomLadderLineFactory;
import ladder.domain.player.PlayerNames;
import ladder.domain.player.Players;
import ladder.external.RandomFactory;
import ladder.view.InputDto;
import ladder.view.InputView;
import ladder.view.ResultView;

public class Main {
    public static void main(String[] args) {
        InputDto inputDto = InputView.scan();

        Players players = inputDto.getPlayers();
        Ladder ladder = new Ladder(players.count(), inputDto.getHeight(), new RandomLadderLineFactory(new RandomFactory()));

        ResultView.printLadderResult(players, ladder, inputDto.getLadderResults());

        Players resultPlayers = ladder.goDown(players);

        PlayerNames targetPlayerNames = InputView.scanTargetPlayers(players);
        ResultView.printLadderResultsByPlayers(targetPlayerNames, resultPlayers, inputDto.getLadderResults());

        InputView.closeScan();
    }
}
