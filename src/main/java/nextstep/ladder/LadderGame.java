package nextstep.ladder;


import nextstep.ladder.domain.line.Lines;
import nextstep.ladder.domain.participant.Participants;
import nextstep.ladder.domain.reward.Rewards;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderGame {
    public static final String ALL = "all";

    public static void main(String[] args) {
        final Participants participants = new Participants(InputView.participantNames());

        final Rewards rewards = new Rewards(participants.getSize(), InputView.ladderRewards());
        final Lines lines = new Lines(InputView.ladderHeight(), participants.getSize());

        OutputView.printLadderResult(participants, lines, rewards);

        while (true) {
            final String selectedParticipant = InputView.resultSelect();
            OutputView.printRewardOnePerson(lines.rewardOnePerson(participants, rewards, selectedParticipant));

            if (ALL.equals(selectedParticipant)) {
                break;
            }
        }
    }
}
