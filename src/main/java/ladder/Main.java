package ladder;

import ladder.domain.Ladder;
import ladder.domain.Players;
import ladder.domain.RandomLineFactory;
import ladder.external.RandomFactory;
import ladder.view.InputDto;
import ladder.view.InputView;
import ladder.view.ResultView;

public class Main {
    public static void main(String[] args) {
        InputDto inputDto = InputView.scan();

        Players players = inputDto.getPlayers();
        Ladder ladder = new Ladder(players.count(), inputDto.getHeight(), new RandomLineFactory(new RandomFactory()));

        ResultView.printLadderResult(players, ladder, inputDto.getLadderResults());

        Players resultPlayers = ladder.goDown(players);

        Players targetPlayers = InputView.scanTargetPlayers(players);
        ResultView.printLadderResultsByPlayers(targetPlayers, resultPlayers, inputDto.getLadderResults());

        InputView.closeScan();
    }
}
