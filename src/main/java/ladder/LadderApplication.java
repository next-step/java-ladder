package ladder;

import static ladder.view.InputView.inputParticipants;
import static ladder.view.InputView.inputParticipant;
import static ladder.view.InputView.inputPrizes;
import static ladder.view.InputView.inputLadderHeight;
import static ladder.view.OutputView.printGameResult;
import static ladder.view.OutputView.printLadderResult;

import ladder.domain.Participants;
import ladder.domain.Ladder;
import ladder.domain.Prizes;
import ladder.strategy.RandomLinkStrategy;

public class LadderApplication {

    public static void main(String[] args) {
        Participants participants = new Participants(inputParticipants());
        Prizes prizes = new Prizes(inputPrizes(), participants.size());
        int height = inputLadderHeight();

        Ladder ladder = new Ladder(participants.size(), height);
        ladder.draw(new RandomLinkStrategy());

        printLadderResult(participants, ladder, prizes);

        ladder.play(participants);

        String participant = inputParticipant();
        printGameResult(participant, participants, prizes);

        String all = inputParticipant();
        printGameResult(all, participants, prizes);
    }
}
