package nextstep;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.LadderResult;
import nextstep.ladder.domain.Name;
import nextstep.ladder.domain.Player;
import nextstep.ladder.domain.Prize;
import nextstep.ladder.domain.RandomGeneratorStrategy;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderMain {
    public static void main(String[] args) {
        List<String> inputNames = InputView.inputNames();
        List<LadderResult> ladderResults = InputView.inputResults().stream().map(LadderResult::new)
                .collect(Collectors.toList());
        int height = InputView.inputLadderHeight();
        checkInput(ladderResults, inputNames);

        LadderGame ladderGame = new LadderGame(inputNames, height, new RandomGeneratorStrategy());
        List<Player> players = ladderGame.progressGame();
        Prize prize = new Prize(players, ladderResults);

        printResultPrompt(ladderGame, ladderResults);
        String viewer;

        do {
            viewer = InputView.inputViewer();
            OutputView.printPrize(prize.getPrize(new Name(viewer)));
        } while (!Objects.equals(viewer, "all"));
    }

    private static void checkInput(List<LadderResult> inputLadderResults, List<String> inputNames) {
        if (inputLadderResults.size() != inputNames.size()) {
            throw new IllegalArgumentException("Input results size is not equal to input names size.");
        }
    }

    private static void printResultPrompt(LadderGame ladderGame, List<LadderResult> inputLadderResults) {
        OutputView.printPlayers(ladderGame.getPlayers());
        OutputView.printLadder(ladderGame.getLines());
        OutputView.printResult(inputLadderResults);
    }
}
