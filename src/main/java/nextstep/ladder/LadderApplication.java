package nextstep.ladder;

import nextstep.ladder.dto.PlayersDto;

public class LadderApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        String[] playersName = inputView.inputPlayersName();
        int ladderHeight = inputView.inputLadderHeight();

        Players players = Players.getNewInstanceByStrings(playersName);
        Ladders ladders = Ladders.makeLaddersByPlayersAndHeight(playersName.length, ladderHeight);

        PlayersDto playersDto = players.toPlayersDto();

        resultView.printPlayersName(playersDto);
        resultView.printLadders(ladders);
    }
}
