package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderResults;
import nextstep.ladder.domain.Players;
import nextstep.ladder.factory.LadderFactory;
import nextstep.ladder.pattern.RandomPointGenerator;
import nextstep.ladder.ui.InputView;
import nextstep.ladder.ui.ResultView;

public class LadderGame {

    public static final String INPUT_CONDITION = "all";

    public static void main(String[] args) {
        Players players = new Players(InputView.getPlayers());
        LadderResults results = LadderResults.of(players.size(), InputView.getResults());
        int height = InputView.getHeight();

        Ladder ladder = LadderFactory.generate(height, players.size(), new RandomPointGenerator());
        ladder.run(players);

        ResultView resultView = new ResultView(players, results);
        resultView.printLadder(ladder);
        printResults(resultView);
    }

    private static void printResults(ResultView resultView) {
        String name;
        while(!(name = InputView.getPlayer()).equals(INPUT_CONDITION)) {
            resultView.printResultOfPlayer(name);
        }
        resultView.printResultsOfAll();
    }
}
