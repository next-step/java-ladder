package nextstep.ladder;


import nextstep.ladder.domain.line.Lines;
import nextstep.ladder.domain.participant.Participants;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderGame {
    public static void main(String[] args) {
        final Participants participants = new Participants(InputView.participantNames());
        final String result = InputView.ladderResult();
        final Lines lines = new Lines(InputView.ladderHeight(), participants.getSize());

        OutputView.printResult(participants, lines);
    }
}
