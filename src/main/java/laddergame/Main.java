package laddergame;

import laddergame.domain.Height;
import laddergame.domain.Ladder;
import laddergame.domain.Players;
import laddergame.domain.Width;
import laddergame.view.InputView;

public class Main {
    public static void main(String[] args) {
        Players players = new Players(InputView.enterPlayerNames());
        Height height = new Height(InputView.enterHeight());

        Width width = players.findWidth();
        Ladder ladder = height.createLadder(width, new RandomStateGenerator());
    }
}
