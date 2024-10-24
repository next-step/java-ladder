package ladder;

import ladder.view.InputView;
import ladder.view.OutputView;

public class Main {

    public static final String CHECK_ALL = "all";

    public static void main(String[] args) {
        PlayersOld playersOld = InputView.inputPlayers();
        String[] inputResults = InputView.inputResult();
        InputResult inputResult = new InputResult(inputResults, playersOld.size());
        int height = InputView.inputHeight();

        LadderOld ladderOld = new LadderOld(height, playersOld.size());
        LadderResult ladderResult = ladderOld.run(playersOld, inputResult);

        OutputView.outputLadderGame(playersOld, ladderOld, inputResult);

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
