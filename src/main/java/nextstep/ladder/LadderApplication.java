package nextstep.ladder;

public class LadderApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        String[] playersName = inputView.inputPlayersName();
        int ladderHeight = inputView.inputLadderHeight();

        Players players = Players.getNewInstanceByStrings(playersName);
        Ladders ladders = Ladders.makeLaddersByPlayersAndHeight(playersName.length, ladderHeight);

        resultView.printPlayersName(players);
        resultView.printLadders(ladders);
    }
}
