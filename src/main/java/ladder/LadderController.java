package ladder;

public class LadderController {

    private final InputView inputView;
    private Ladder ladder;

    public LadderController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        ladder = new Ladder(inputView.inputNames().size(), inputView.inputHeight());
        ladder.drawLine();
    }
}
