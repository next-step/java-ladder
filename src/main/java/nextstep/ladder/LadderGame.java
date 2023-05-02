package nextstep.ladder;


import nextstep.ladder.domain.line.Lines;
import nextstep.ladder.domain.participant.Participants;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderGame {
    public static void main(String[] args) {
        final String participantNames = InputView.participantNames();
        final int ladderHeight = InputView.ladderHeight();

        final Participants participants = new Participants(participantNames);
        final Lines lines = new Lines(ladderHeight, participants.getSize());

        OutputView.printResult(participants, lines);
    }
}
