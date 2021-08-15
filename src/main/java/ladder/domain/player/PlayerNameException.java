package ladder.domain.player;

public class PlayerNameException extends RuntimeException {

	private static final String DEFAULT_MESSAGE = "참가자의 이름은 1~5글자만 허용됩니다.";

	public PlayerNameException() {
		super(DEFAULT_MESSAGE);
	}

}
