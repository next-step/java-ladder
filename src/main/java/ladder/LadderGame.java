package ladder;

public class LadderGame {
    private Players players;

    public void start(){
        players = new Players(InputView.inputPlayerNames());

        int ladderHeight = InputView.inputLadderHeight();
    }
}
