package ladder;

import ladder.domain.Ladder;
import ladder.domain.Participants;
import ladder.domain.Prizes;
import ladder.strategy.MovingStrategy;
import ladder.strategy.RandomMovingStrategy;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderGame {
    private static final InputView inputView = new InputView();
    private static final ResultView resultView = new ResultView();

    public static void play() {
        Participants participants = inputView.getNames();
        Prizes prizes = inputView.getPrizes(participants);
        int height = inputView.getLadderHeight();

        MovingStrategy movingStrategy = new RandomMovingStrategy();
        Ladder ladder = new Ladder(height, participants.size(), movingStrategy);

        resultView.printLadder(participants.getParticipantNames(),
                ladder,
                prizes.getPrizeNames());

        participants = play(participants, ladder);

        printResult(participants, prizes);
    }

    private static Participants play(Participants participants, Ladder ladder) {
        for (int i = 0; i < ladder.getHeight(); i++) {
            participants = participants.playOneFloor(i, ladder.getFloors().get(i));
        }
        return participants;
    }

    private static void printResult(Participants participants, Prizes prizes) {
        boolean keepGoing = true;
        while (keepGoing) {
            String name = inputView.getParticipant();
            resultView.printResult(participants, prizes, name);

            if (name.equals("all")) {
                keepGoing = false;
            }
        }
    }
}
