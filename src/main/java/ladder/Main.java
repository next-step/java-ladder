package ladder;

import ladder.view.InputView;
import ladder.view.OutputView;

public class Main {

    public static void main(String[] args) {

        String inputPlayerNames = InputView.getInputPlayerNames();
        String inputCustomPrize = InputView.getCustomPrize();
        int inputLadderHeight = InputView.getInputLadderHeight();

        LadderPlayers players = LadderPlayers.createPlayers(inputPlayerNames);
        Prizes prizes = Prizes.createPrizes(inputCustomPrize);

        Ladder ladder = new Ladder(inputLadderHeight, players.size(), prizes.size());
        OutputView.printPlayer(players);
        OutputView.printLadders(ladder);
        OutputView.printPrizes(prizes);


        LadderResult ladderResult = new LadderResult(ladder, players, prizes);
        String userInputPrizes = null;
        do {
            userInputPrizes = InputView.getInputPrizes();
            OutputView.printLadderGameResult(ladderResult, userInputPrizes);
        } while (isEnd(userInputPrizes));
    }

    private static boolean isEnd(String userInputPrizes) {
        return !userInputPrizes.equals("exit");
    }

}
