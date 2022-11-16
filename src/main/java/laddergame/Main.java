package laddergame;

import laddergame.domain.Players;
import laddergame.domain.Results;
import laddergame.domain.ladder.Ladder;
import laddergame.domain.ladder.Size;
import laddergame.util.RandomValueGenerator;
import laddergame.view.InputView;

public class Main {
    public static void main(String[] args) {
        Players players = new Players(InputView.enterPlayerNames());
        Results results = new Results(InputView.enterResults());

        Size size = Size.calculate(InputView.enterHeight(), players);
        Ladder ladder = Ladder.create(size, new RandomValueGenerator());
    }
}
