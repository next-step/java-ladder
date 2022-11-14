package nextstep.ladder.controller;

import java.util.List;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.ladder.Results;
import nextstep.ladder.domain.linestrategy.RandomLineGenerator;
import nextstep.ladder.domain.participant.ParticipantsOrderByInput;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderController {

	private static String ALL = "all";

	public void draw() {
		InputView inputView = new InputView();
		ParticipantsOrderByInput participantsOrderByInput = new ParticipantsOrderByInput(inputView.getParticipants());
		Results results = new Results(participantsOrderByInput.size(), inputView.getResults());

		Ladder ladder = new Ladder(participantsOrderByInput.size(), inputView.getLadderHeight(), new RandomLineGenerator());

		OutputView outputView = new OutputView();
		outputView.printLadder(participantsOrderByInput, ladder, results);

		while (!results.isDone()) {
			String participant = inputView.getParticipant();

			List<String> names = participantsOrderByInput.getMatchedName(participant);
			names.forEach(name -> results.put(name, ladder.getEnd(participantsOrderByInput.indexOf(name))));

			outputView.printResultHeader();
			names.forEach(name -> outputView.printNameAndResult(name, results.get(name)));
		}
	}
}