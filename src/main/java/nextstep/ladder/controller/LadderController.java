package nextstep.ladder.controller;

import java.util.HashMap;
import java.util.Map;

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

		Map<String, String> resultMap = new HashMap<>();

		participantsOrderByInput.getNames()
			.forEach(name -> {
				int end = ladder.getEnd(participantsOrderByInput.indexOf(name));
				String result = results.get(end);
				resultMap.put(name, result);
			});

		while (true) {
			String participant = inputView.getParticipant();
			outputView.printResultHeader();
			if (ALL.equals(participant)) {
				resultMap.forEach(outputView::printNameAndResult);
				return;
			} else if (participantsOrderByInput.hasName(participant)) {
				outputView.printResult(resultMap.get(participant));
			}
		}
	}
}