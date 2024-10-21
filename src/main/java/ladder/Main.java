package ladder;

import ladder.view.InputView;
import ladder.view.OutputView;

public class Main {

    public static final String CHECK_ALL = "all";

    public static void main(String[] args) {
        Players players = InputView.inputPlayers();
        InputResult inputResult = InputView.inputResult();
        inputResult.validSize(players.size());
        int height = InputView.inputHeight();

        Ladder ladder = new Ladder(height, players.size());
        LadderResult ladderResult = ladder.run(players, inputResult);

        OutputView.outputLadderGame(players, ladder, inputResult);

        String personName = InputView.wantPerson();
        while (!personName.equals(CHECK_ALL)) {
            System.out.println();
            OutputView.outputOneResult(personName, ladderResult);
            personName = InputView.wantPerson();
        }
        System.out.println();
        OutputView.outputAllResult(ladderResult);
    }
}
