package ladder.domain.player;

public class PlayerNameException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "참가자의 이름은 1~5글자만 허용됩니다. 이름 길이 : %d";

    public PlayerNameException() {
        super(DEFAULT_MESSAGE);
    }

    public PlayerNameException(int lengthOfName) {
        super(String.format(DEFAULT_MESSAGE, lengthOfName));
    }

}
