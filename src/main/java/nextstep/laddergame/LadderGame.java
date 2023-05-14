package nextstep.laddergame;


import nextstep.laddergame.domain.ladder.Lines;
import nextstep.laddergame.domain.participant.Participants;
import nextstep.laddergame.domain.reward.Rewards;
import nextstep.laddergame.view.InputView;
import nextstep.laddergame.view.OutputView;

public class LadderGame {
    public static final String ALL = "all";

    public static void main(String[] args) {
        final Participants participants = new Participants(InputView.participantNames());

        final Rewards rewards = new Rewards(participants.getSize(), InputView.ladderRewards());
        final Lines lines = new Lines(InputView.ladderHeight(), participants.getSize());

        OutputView.printLadderResult(participants, lines, rewards);

        while (true) {
            final String selectedParticipant = InputView.resultSelect();

            if (ALL.equals(selectedParticipant)) {
                OutputView.printRewardAll(lines.rewardAll(participants, rewards));
                break;
            }

            OutputView.printRewardOnePerson(lines.rewardOnePerson(participants, rewards, selectedParticipant));
        }
    }
}
