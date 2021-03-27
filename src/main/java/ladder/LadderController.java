package ladder;

public class LadderController {

    private final InputView inputView;
    private Ladder ladder;

    public LadderController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        InputManagement inputManagement = new InputManagement(inputView.inputNames(), inputView.inputHeight());

        ladder = new Ladder(inputManagement.getNames().size(), inputView.inputHeight());
        ladder.drawLine();
    }
}
