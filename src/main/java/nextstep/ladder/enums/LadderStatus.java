package nextstep.ladder.enums;

import java.util.Arrays;

import nextstep.ladder.exceptions.NotFoundLadderStatusException;

public enum LadderStatus {
	LINKED(1),
	UNLINKED(2);

	private final int status;

	LadderStatus(int status) {
		this.status = status;
	}

	public static LadderStatus of(int status) {
		return Arrays.stream(LadderStatus.values())
			.filter(e -> e.status == status)
			.findFirst()
			.orElseThrow(() -> new NotFoundLadderStatusException("사다리 상태 코드가 잘못되었습니다."));
	}
}
