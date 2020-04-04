package nextstep.ladder;

public class LadderController {
    private static InputView inputView = InputView.getInputView();

    public static void main(String[] args) {
        Users users = inputView.enterUserNames();
        int ladderHeight = inputView.enterLadderHeight();

    }
}
