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
        Players players = Players.create(playersName);

        List<String> laddersStringResults = inputView.inputLaddersResults();
        LaddersResults laddersResults = LaddersResults.create(laddersStringResults);

        int ladderHeight = inputView.inputLadderHeight();
        Ladders ladders = Ladders.of(playersName.size(), ladderHeight);

        PlayersDto playersDto = players.toPlayersDto();

        resultView.printPlayersName(playersDto);
        resultView.printLadders(ladders);
        resultView.printLaddersResults(laddersResults);

        LadderGame ladderGame = LadderGame.of(ladders, players, laddersResults);

        ladderGame.startGame(inputView, resultView);
    }
}
