package ladder;

import ladder.domain.LadderGame;
import ladder.domain.Players;
import ladder.domain.RandomDecision;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.Arrays;
import java.util.Map;

public class LadderMain {
    private static String RESULT_MSG = "사다리 결과";
    private static String END_WORD = "all";

    public static void main(String[] args) {

        Players players = new Players(InputView.inputPlayers());
        String[] results = InputView.inputResults(players.size());

        LadderGame ladderGame = new LadderGame(InputView.inputHeight(), players, new RandomDecision());

        OutputView.printMsg(RESULT_MSG);

        OutputView.print(players.getPlayerNames());
        OutputView.printLadder(ladderGame.getLines());
        OutputView.print(Arrays.asList(results));

        Map<String, String> result = ladderGame.getAllPlayerResult(results);

        showExecuteResult(result);
    }

    private static void showExecuteResult(Map<String, String> result) {
        String searchTarget = InputView.inputSearchTarget();
        showAll(result, searchTarget);

        while (!searchTarget.equals(END_WORD)) {
            showEach(result, searchTarget);
            searchTarget = InputView.inputSearchTarget();
        }
        showAll(result, searchTarget);
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
