package nextstep.laddergame.view;

public class LadderMain {
    private InputView inputView;
    public ResultView resultView;

    public LadderMain() {
        this.inputView = new InputView();
        this.resultView = new ResultView();

    }
    public void run() {
        String participants =inputView.getParticipant();
        int ladderHeight = inputView.getLadderHeight();

    }
}
