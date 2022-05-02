package nextstep.ladder;

import nextstep.ladder.dto.PlayersDto;

public class LadderApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        String[] playersName = inputView.inputPlayersName();
        String[] laddersStringResults = inputView.inputLaddersResults();
        int ladderHeight = inputView.inputLadderHeight();

        Players players = Players.getNewInstanceByStrings(playersName);
        Ladders ladders = Ladders.makeLaddersByPlayersAndHeight(playersName.length, ladderHeight);
        LaddersResults laddersResults = LaddersResults.makeLaddersResultsByUserInput(laddersStringResults);

        PlayersDto playersDto = players.toPlayersDto();

        resultView.printPlayersName(playersDto);
        resultView.printLadders(ladders);
        resultView.printLaddersResults(laddersResults);

        String playerName = inputView.inputWinner();

        int playerPosition = players.findPositionByPlayerName(playerName);
        String result = laddersResults.findLadderResultByEndPosition(ladders.findLadderResult(playerPosition));

        resultView.printPlayerResult(result);
    }
}
