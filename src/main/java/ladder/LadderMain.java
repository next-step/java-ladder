package ladder;

import ladder.domain.LadderGame;
import ladder.domain.Players;
import ladder.domain.RandomDecision;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.Arrays;
import java.util.Map;

public class LadderMain {

    private static String END_WORD = "all";

    public static void main(String[] args) {

        Players players = new Players(InputView.inputPlayers());

        String[] results = InputView.inputResults(players.size());

        LadderGame ladderGame = new LadderGame(InputView.inputHeight(), players, new RandomDecision());

        OutputView.printGeneratedLadder(ladderGame, results);

        showExecuteResult(ladderGame.getAllPlayerResult(results));
    }

    private static void showExecuteResult(Map<String, String> result) {
        String searchTarget = InputView.inputSearchTarget();
        showAll(result, searchTarget);
        if (isEndCondition(searchTarget)) {
            return ;
        }
        while (!isEndCondition(searchTarget)) {
            showEach(result, searchTarget);
            searchTarget = InputView.inputSearchTarget();
        }
        showAll(result, searchTarget);
    }

    private static boolean isEndCondition(String searchTarget) {
        return searchTarget.equals(END_WORD);
    }

    private static void showEach(Map<String, String> result, String searchTarget) {
        if (!result.containsKey(searchTarget)) {
            return;
        }
        OutputView.printResult(searchTarget, result.get(searchTarget));
    }

    private static void showAll(Map<String, String> result, String searchTarget) {
        if (!searchTarget.equals(END_WORD)) {
            return;
        }
        OutputView.printAllResult(result);
    }
}
