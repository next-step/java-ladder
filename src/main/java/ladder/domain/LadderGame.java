package ladder.domain;

import ladder.domain.ladder.Ladder;
import ladder.domain.player.Players;
import ladder.domain.product.Products;
import ladder.domain.util.RightPointRandom;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderGame {
    public void run() {
        Players players = new Players(InputView.inputGamePlayers());
        Products products = new Products(InputView.inputProducts(), players.getPlayerCount());
        Ladder ladder = new Ladder(players.getPlayerCount(), InputView.inputLadderSize(),
                new RightPointRandom());
        ResultView.printLadderResult(players, products, ladder.getLines());
        ResultView.printResult(players, products, ladder);
    }
}
