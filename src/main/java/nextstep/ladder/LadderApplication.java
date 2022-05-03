package nextstep.ladder;

import nextstep.ladder.domain.*;
import nextstep.ladder.dto.PlayersDto;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.List;

public class LadderApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        List<String> playersName = inputView.inputPlayersName();
        List<String> laddersStringResults = inputView.inputLaddersResults();
        int ladderHeight = inputView.inputLadderHeight();

        Ladders ladders = Ladders.of(playersName.size(), ladderHeight);
        Players players = Players.create(playersName);
        LaddersResults laddersResults = LaddersResults.create(laddersStringResults);
        PlayersDto playersDto = players.toPlayersDto();

        resultView.printLadderStatus(playersDto, ladders, laddersResults);

        LadderGame ladderGame = LadderGame.of(ladders, players, laddersResults);
        ladderGame.startGame(inputView, resultView);
    }
}
