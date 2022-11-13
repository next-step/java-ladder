package laddergame;

import laddergame.domain.Height;
import laddergame.domain.Ladder;
import laddergame.domain.Players;
import laddergame.domain.Width;
import laddergame.util.RandomValueGenerator;
import laddergame.view.InputView;
import laddergame.view.OutputView;

public class Main {
    public static void main(String[] args) {
        Players players = new Players(InputView.enterPlayerNames());
        Height height = new Height(InputView.enterHeight());

        Width width = new Width(players);
        Ladder ladder = height.createLadder(width, new RandomValueGenerator());

        OutputView.printResult(players, ladder);
    }
}
