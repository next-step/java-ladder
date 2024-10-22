package nextstep.ladder;

import nextstep.ladder.model.*;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LadderGameApplication {
    public static void main(String[] args) {
        List<String> playerNames = InputView.inputPlayers();
        List<Prize> prizes = InputView.inputPrizes().stream().map(Prize::new).collect(Collectors.toList());
        int height = InputView.inputLadderHeight();

        LadderGame ladderGame = new LadderGame(playerNames);
        Ladder ladder = ladderGame.makeLadder(height, new RandomLineGenerator());

        LadderResult ladderResult = ladderGame.makeLadderResult(prizes);

        ResultView.printResultLetters();
        ResultView.printPlayers(ladderGame.getPlayers());
        ResultView.printLadder(ladder);
        ResultView.printPrizes(prizes);

        while (true) {
            String input = InputView.inputPlayerForResult();
            Map<Player, Prize> result = ladderResult.getResultByInput(input);
            ResultView.printResult(result);
            if (input.equals("all")) {
                break;
            }
        }
    }
}
