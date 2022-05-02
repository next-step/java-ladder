package nextstep.ladder;

import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.Ladders;
import nextstep.ladder.domain.LaddersResults;
import nextstep.ladder.domain.Players;
import nextstep.ladder.dto.PlayersDto;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.Map;

public class LadderApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        String[] playersName = inputView.inputPlayersName();
        Players players = Players.getNewInstanceByStrings(playersName);

        String[] laddersStringResults = inputView.inputLaddersResults();
        LaddersResults laddersResults = LaddersResults.makeLaddersResultsByUserInput(laddersStringResults);

        int ladderHeight = inputView.inputLadderHeight();
        Ladders ladders = Ladders.makeLaddersByPlayersAndHeight(playersName.length, ladderHeight, laddersResults);

        PlayersDto playersDto = players.toPlayersDto();

        resultView.printPlayersName(playersDto);
        resultView.printLadders(ladders);
        resultView.printLaddersResults(laddersResults);

        LadderGame ladderGame = new LadderGame(ladders, players);

        String playerName = inputView.inputWinner();

        Map<String, String> resultMap = ladderGame.findResultByPlayerName(playerName);

        resultView.printPlayerResult(resultMap);
    }
}
