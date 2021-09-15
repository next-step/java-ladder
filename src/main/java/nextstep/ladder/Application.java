package nextstep.ladder;

import nextstep.ladder.domain.Lines;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.ui.InputView;
import nextstep.ladder.ui.ResultView;

public class Application {
	public static void main(String[] args) {
		Participants participants = new Participants(InputView.inputParticipantNames());

		Lines lines = new Lines(participants.countOfPerson(), InputView.inputMaximumHeight());

		ResultView.drawResult(participants, lines);
	}
}
