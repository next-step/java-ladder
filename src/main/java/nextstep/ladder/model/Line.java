package nextstep.ladder.model;

import java.util.ArrayList;
import java.util.List;

import nextstep.ladder.enums.LadderStatus;
import nextstep.ladder.exceptions.LadderStatusAddFailureException;

public class Line {

	private final List<LadderStatus> ladderStatuses;

	public Line() {
		this.ladderStatuses = new ArrayList<>();
	}

	public void addLadderStatus(LadderStatus currentLadderStatus) {
		if (ladderStatuses.size() > 0) {
			LadderStatus previousLadderStatus = ladderStatuses.get(ladderStatuses.size() - 1);
			ladderStatusValidate(previousLadderStatus, currentLadderStatus);
		}

		ladderStatuses.add(currentLadderStatus);
	}

	private void ladderStatusValidate(LadderStatus previousLadderStatus, LadderStatus currentLadderStatus) {
		if (previousLadderStatus.equals(LadderStatus.LINKED) &&
			currentLadderStatus.equals(LadderStatus.LINKED)) {
			throw new LadderStatusAddFailureException("이전 사다리가 연결된 상태입니다.");
		}
	}
}
