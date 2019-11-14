package ladder.domain;

import java.util.List;

public class LadderInput {

	private final Participants participants;
	private final LadderResult ladderResult;

	public LadderInput(Participants participants) {
		this.participants = participants;
		this.ladderResult = new LadderResult(participants.getNames());
	}

	public LadderInput(String[] inputNames, String[] inputResult) {
		validateInputData(inputNames, inputResult);
		this.participants = new Participants(inputNames);
		this.ladderResult = new LadderResult(inputResult);
	}

	private void validateInputData(String[] inputNames, String[] inputResult) {
		if (inputNames.length != inputResult.length) {
			throw new IllegalArgumentException("사다리에 참여하는 사람 수와 결과 수는 다를 수 없습니다");
		}
	}

	public List<String> getNames() {
		return participants.getNames();
	}

	public int count() {
		return participants.count();
	}

	public List<String> getResult() {
		return ladderResult.getResult();
	}

}
