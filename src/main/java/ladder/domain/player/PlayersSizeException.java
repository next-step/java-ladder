package ladder.domain.player;

public class PlayersSizeException extends RuntimeException {

	private static final String DEFAULT_MESSAGE = "참가자는 2명 이상이어야 합니다.";

	public PlayersSizeException() {
		super(DEFAULT_MESSAGE);
	}

}
