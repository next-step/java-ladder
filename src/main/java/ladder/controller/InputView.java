package ladder.controller;

public class InputView {
    private static InputView INSTANCE = null;

    public InputView() {
    }

    public static InputView getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new InputView();
        }
        return INSTANCE;
    }
}
