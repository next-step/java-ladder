package ladder;

public class LadderGameApplication {
    public static void main(String[] args) {
        try {
            String players = InputView.inputPlayer();
            int ladderHeight = InputView.inputLadderHeight();

            InputView inputView = new InputView(players, ladderHeight);

            LadderController ladderController = new LadderController(inputView);

            ResultView resultView = ladderController.startLadderGame();

            resultView.printOutPlayers();
            System.out.println();
            resultView.printOutLineResult();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
