package ladder.controller;

public class ResultView {
    private static ResultView INSTANCE = null;

    public ResultView() {
    }

    public static ResultView getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ResultView();
        }
        return INSTANCE;
    }


}
