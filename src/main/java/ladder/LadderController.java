package ladder;

public class LadderController {

    private final InputView inputView;

    public LadderController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        InputManagement inputManagement = new InputManagement(inputView.inputNames(), inputView.inputHeight());

        Ladder ladder = new Ladder(inputManagement.getNames().size(), inputManagement.getHeight());
        ladder.drawLine();

        ResultView resultView = new ResultView();
        resultView.print(inputManagement.getNames(), ladder.getLadder());
    }
}
