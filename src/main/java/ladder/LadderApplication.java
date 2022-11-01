package ladder;

import ladder.domain.Ladder;
import ladder.domain.LadderGame;
import ladder.domain.Names;
import ladder.domain.Results;
import ladder.view.InputView;
import ladder.view.ResultView;

import static ladder.domain.LadderGame.STR_ALL;

public class LadderApplication {

    public static void main(String[] args) {
        String[] candidateNames = InputView.inputCandidateNames();
        Names names = Names.of(candidateNames);

        String[] inputResults = InputView.inputExecutionResult();
        Results results = Results.of(inputResults);
        LadderGame ladderGame = new LadderGame(names, results);

        Integer maxHeight = InputView.inputMaxLadderHeight();
        Ladder ladder = Ladder.of(names.getCountOfNames(), maxHeight);

        ResultView.printResult(ladderGame.getNames(), ladder);
        printCandidatesResults(ladderGame, ladder);
    }

    private static void printCandidatesResults(LadderGame ladderGame, Ladder ladder) {
        String candidate;
        do {
            candidate = InputView.inputResultCandidateName();
            if (!candidate.equals(STR_ALL)) {
                ladderGame.validateCandidateName(candidate);
                ResultView.printLadderResult(ladderGame.getExecutionResult(candidate, ladder));
            }
            if (candidate.equals(STR_ALL)) {
                ResultView.printLadderResultAll(ladderGame.getExecutionResultAll(ladder));
            }
        } while (!candidate.equals(STR_ALL));
    }

}
