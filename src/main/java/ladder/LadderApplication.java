package ladder;

import ladder.view.InputView;

import java.util.List;

public class LadderApplication {

    public static void main(String[] args) {
        List<String> playerNames = InputView.inputPlayers();
        int ladderHeight = InputView.inputHeight();
    }
}
