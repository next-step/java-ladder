package nextstep.laddergame;


import nextstep.laddergame.domain.ladder.Ladder;
import nextstep.laddergame.domain.participant.Participants;
import nextstep.laddergame.domain.reward.Rewards;
import nextstep.laddergame.view.InputView;
import nextstep.laddergame.view.OutputView;

public class LadderGame {
    public static final String ALL = "all";

    public static void main(String[] args) {
        final Participants participants = new Participants(InputView.participantNames());

        final Rewards rewards = new Rewards(participants.getSize(), InputView.ladderRewards());
        final Ladder ladder = new Ladder(InputView.ladderHeight(), participants.getSize());

        OutputView.printLadderResult(participants, ladder, rewards);

        while (true) {
            final String selectedParticipant = InputView.resultSelect();

            if (ALL.equals(selectedParticipant)) {
                OutputView.printRewardAll(ladder.ladderGameAllPerson(participants, rewards));
                break;
            }

            OutputView.printRewardOnePerson(ladder.ladderGameOnePerson(participants, rewards, selectedParticipant));
        }
    }
}
