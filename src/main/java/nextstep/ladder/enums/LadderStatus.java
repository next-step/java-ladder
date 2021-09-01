package nextstep.ladder.enums;

import java.util.Arrays;

import nextstep.ladder.exceptions.NotFoundLadderStatusException;

public enum LadderStatus {
	LINKED(true, "-----"),
	UNLINKED(false, "     ");

	private final boolean status;
	private final String text;

	LadderStatus(boolean status, String text) {
		this.status = status;
		this.text = text;
	}

	public static LadderStatus of(boolean status) {
		return Arrays.stream(LadderStatus.values())
			.filter(e -> e.status == status)
			.findFirst()
			.orElseThrow(() -> new NotFoundLadderStatusException("사다리 상태 코드가 잘못되었습니다."));
	}

	public String getText() {
		return this.text;
	}
}
