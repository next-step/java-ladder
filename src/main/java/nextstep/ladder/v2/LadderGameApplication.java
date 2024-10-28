package nextstep.ladder.v2;

import nextstep.ladder.v2.model.*;
import nextstep.ladder.v2.view.InputView;
import nextstep.ladder.v2.view.ResultView;

import java.util.List;
import java.util.Map;

public class LadderGameApplication {
    public static void main(String[] args) {
        List<String> names = InputView.inputPlayers();
        List<String> prizes = InputView.inputPrizes();
        int height = InputView.inputLadderHeight();

        Ladder ladder = Ladder.of(names.size()).createLadder(height, new RandomPointGenerator());
        LadderGame ladderGame = new LadderGame(names, ladder);
        LadderResult ladderResult = ladderGame.createLadderResult(prizes);

        ResultView.printResultLetters();
        ResultView.printPlayers(ladderGame.getPlayerGroup().getPlayers());
        ResultView.printLadder(ladder.getLines());
        ResultView.printPrizes(prizes);

        while (true) {
            String input = nextstep.ladder.v1.view.InputView.inputPlayerForResult();
            Player player = new Player(input);
            boolean isAll = input.equals("all");
            Map<Player, Prize> result = ladderResult.getResultByPlayer(player);
            if (isAll) {
                result = ladderResult.getAllResult();
            }
            ResultView.printResult(result);

            if (isAll) {
                break;
            }
        }
    }
}
