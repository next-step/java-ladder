package ladder;

public class LadderGameMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        Players players = new Players(inputView.inputPlayerName());
        Height height = new Height(inputView.inputHeight());

        Ladder ladder = new Ladder(height, players);
        outputView.showLadder(ladder, players);

    }
}
