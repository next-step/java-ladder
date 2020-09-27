package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderResults;
import nextstep.ladder.domain.Player;
import nextstep.ladder.factory.LadderFactory;
import nextstep.ladder.pattern.RandomPointGenerator;
import nextstep.ladder.ui.InputView;
import nextstep.ladder.ui.ResultView;

import java.util.List;

public class LadderGame {

    public static void main(String[] args) {
        List<Player> players = InputView.getPlayers();
        LadderResults results = LadderResults.of(players.size(), InputView.getResults());
        int height = InputView.getHeight();

        Ladder ladder = LadderFactory.generate(height, players.size(), new RandomPointGenerator());
        ladder.run(players);

        ResultView.printLadder(ladder, players, results);
    }
}
