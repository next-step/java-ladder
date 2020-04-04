package ladder;

import ladder.domain.Height;
import ladder.domain.Players;
import ladder.view.InputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        Players players = inputView.inputPlayerName();
        Height height = inputView.inputHeight();
    }
}
