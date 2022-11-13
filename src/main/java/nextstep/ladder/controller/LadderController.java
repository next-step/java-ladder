package nextstep.ladder.controller;

import java.util.HashMap;
import java.util.Map;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.ladder.Results;
import nextstep.ladder.domain.linestrategy.RandomLineGenerator;
import nextstep.ladder.domain.participant.Participants;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderController {

	private static String ALL = "all";

	public void draw() {
		InputView inputView = new InputView();
		Participants participants = new Participants(inputView.getParticipants());
		Results results = new Results(participants.size(), inputView.getResults());

		Ladder ladder = new Ladder(participants.size(), inputView.getLadderHeight(), new RandomLineGenerator());

		OutputView outputView = new OutputView();
		outputView.printLadder(participants, ladder, results);

		Map<String, String> resultMap = new HashMap<>();

		participants.getNames()
			.forEach(name -> {
				int end = ladder.getEnd(participants.indexOf(name));
				String result = results.get(end);
				resultMap.put(name, result);
			});

		while (true) {
			String participant = inputView.getParticipant();
			outputView.printResultHeader();
			if (ALL.equals(participant)) {
				resultMap.forEach(outputView::printNameAndResult);
				return;
			} else if (participants.hasName(participant)) {
				outputView.printResult(resultMap.get(participant));
			}
		}
	}
}