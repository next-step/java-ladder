package ladder;

import ladder.domain.Ladder;
import ladder.domain.Participants;
import ladder.domain.Prizes;
import ladder.strategy.RandomGeneratorStrategy;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderGame {
    private static final InputView inputView = new InputView();
    private static final ResultView resultView = new ResultView();

    public static void play() {
        Participants participants = inputView.getNames();
        Prizes prizes = inputView.getPrizes(participants);
        int height = inputView.getLadderHeight();

        Ladder ladder = new Ladder(participants.size(), height, new RandomGeneratorStrategy());

        resultView.printLadder(participants.getParticipantNames(),
                ladder,
                prizes.getPrizeNames());
        printResult(participants, ladder, prizes);
    }

    private static void printResult(Participants participants, Ladder ladder, Prizes prizes) {
        while (true) {
            String name = inputView.getParticipant();
            if (name.equals("all")) {
                resultView.printResultALL(participants, ladder, prizes);
                return;
            }
            resultView.printPrizeResult(prizes, ladder.findPrizeIndex(participants.getParticipant(name).getPosition()));
        }
    }
}
