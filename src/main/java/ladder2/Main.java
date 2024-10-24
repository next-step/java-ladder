package ladder2;

import ladder.InputResult;
import ladder2.view.InputView;
import ladder2.view.OutputView;

public class Main {

    public static final String CHECK_ALL = "all";

    public static void main(String[] args) {
        RandomLineGenerator randomLineGenerator = new RandomLineGenerator();
        LadderRandomGenerator ladderRandomGenerator = new LadderRandomGenerator(randomLineGenerator);

        Players players = InputView.inputPlayers();
        int playerCount = players.size();
        String[] inputResults = InputView.inputResult();
        InputResult inputResult = new InputResult(inputResults, playerCount);

        int height = InputView.inputHeight();
        Ladder ladder = ladderRandomGenerator.generateLadder(playerCount, height);
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
