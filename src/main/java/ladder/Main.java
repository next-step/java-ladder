package ladder;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Positions playerPositions = InputView.participantsNameView();
        Positions resultPositions = InputView.resultView(playerPositions);
        Height height = InputView.ladderHeightView();

        Ladder ladder = new Ladder(height, new PositionGroup(playerPositions, resultPositions));
        ResultView.ladderResultView(ladder);

        ladder.start();

        loopSearchResult(ladder);
    }

    private static void loopSearchResult(Ladder ladder) {
        while (true) {
            boolean continuousLoop = validateSearchResult(ladder);
            if (!continuousLoop) {
                break;
            }
        }
    }

    private static boolean validateSearchResult(Ladder ladder) {
        try {
            return searchResult(ladder);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return validateSearchResult(ladder);
        }
    }

    private static boolean searchResult(Ladder ladder) {
        String searchValue = InputView.searchResult();
        List<Result> results = ladder.results(searchValue);
        ResultView.searchResultView(results);
        return continuousLoop(searchValue);
    }

    private static boolean continuousLoop(String searchValue) {
        return !searchValue.equals(Ladder.ALL_RESULT);
    }
}
