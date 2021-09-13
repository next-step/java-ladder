package nextstep.ladder;

import nextstep.ladder.domain.Lines;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.ui.InputView;
import nextstep.ladder.ui.ResultView;

public class Application {
	public static void main(String[] args) {
		InputView inputView = new InputView();
		ResultView resultView = new ResultView();

		Participants participants = new Participants(inputView.InputParticipantNames());

		Lines lines = new Lines(participants.names().size(), inputView.InputMaximumHeight());

		resultView.drawResult(participants, lines);
	}
}
