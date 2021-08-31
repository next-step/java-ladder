package nextstep.ladder.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import nextstep.ladder.enums.LadderStatus;
import nextstep.ladder.exceptions.LadderStatusAddFailureException;

public class Line {

	private final Random RANDOM = new Random();
	private final List<LadderStatus> ladderStatuses;

	public Line() {
		this.ladderStatuses = new ArrayList<>();
	}

	public void addLadderStatus(LadderStatus currentLadderStatus) {
		if (!isValidLadderStatus(currentLadderStatus)) {
			throw new LadderStatusAddFailureException("이전 사다리가 연결된 상태입니다.");
		}

		ladderStatuses.add(currentLadderStatus);
	}

	public void addRandomLadderStatus() {
		LadderStatus ladderStatus = LadderStatus.of(RANDOM.nextBoolean());

		if (!isValidLadderStatus(ladderStatus)) {
			ladderStatus = LadderStatus.UNLINKED;
		}

		addLadderStatus(ladderStatus);
	}

	private boolean isValidLadderStatus(LadderStatus currentLadderStatus) {
		if (ladderStatuses.isEmpty()) {
			return true;
		}

		LadderStatus previousLadderStatus = ladderStatuses.get(ladderStatuses.size() - 1);

		if (previousLadderStatus.equals(LadderStatus.LINKED) &&
			currentLadderStatus.equals(LadderStatus.LINKED)) {
			return false;
		}

		return true;
	}

	public LadderStatus getLadderStatus(int index) {
		return ladderStatuses.get(index);
	}

	public int size() {
		return ladderStatuses.size();
	}
}
