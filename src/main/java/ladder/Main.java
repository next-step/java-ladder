package ladder;

import java.util.List;

import ladder.view.InputView;

public class Main {
    public static void main(String[] args) {
        List<Player> players = InputView.inputPlayers();
        int height = InputView.inputHeight();
    }
}
