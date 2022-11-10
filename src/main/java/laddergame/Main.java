package laddergame;

import laddergame.domain.Players;
import laddergame.view.InputView;

public class Main {
    public static void main(String[] args) {
        Players players = new Players(InputView.enterPlayerNames());
    }
}
