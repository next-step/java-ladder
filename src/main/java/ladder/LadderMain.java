package ladder;

public class LadderMain {

    public static void main(String[] args) {
        String playersNames = InputView.inputPlayersName();
        int ladderHeight = InputView.inputLadderHeight();

        LadderGame ladderGame = new LadderGame(playersNames, ladderHeight);
        ResultView.printResult(ladderGame);
    }
}
