package ladder;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Elements playerElements = InputView.participantsNameView();
        Elements resultElements = InputView.resultView(playerElements);
        Height height = InputView.ladderHeightView();

        LadderGame ladderGame = new LadderGame(new ElementGroup(playerElements, resultElements), height);
        ResultView.ladderResultView(ladderGame);

        ladderGame.start();

        loopSearchResult(ladderGame);
    }

    private static void loopSearchResult(LadderGame ladderGame) {
        while (true) {
            boolean continuousLoop = validateSearchResult(ladderGame);
            if (!continuousLoop) {
                break;
            }
        }
    }

    private static boolean validateSearchResult(LadderGame ladderGame) {
        try {
            return searchResult(ladderGame);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return validateSearchResult(ladderGame);
        }
    }

    private static boolean searchResult(LadderGame ladderGame) {
        String searchValue = InputView.searchResult();
        List<Result> results = ladderGame.results(searchValue);
        ResultView.searchResultView(results);
        return continuousLoop(searchValue);
    }

    private static boolean continuousLoop(String searchValue) {
        return !searchValue.equals(LadderGame.ALL_RESULT);
    }
}
