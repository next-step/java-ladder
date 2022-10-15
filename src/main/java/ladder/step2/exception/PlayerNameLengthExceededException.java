package ladder.step2.exception;

public class PlayerNameLengthExceededException extends IllegalArgumentException {
    private static final String PLAYER_NAME_LENGTH_EXCEEDED_EXCEPTION_MESSAGE = "플레이어 이름은 5자를 초과할 수 없습니다.";
    
    public PlayerNameLengthExceededException() {
        super(PLAYER_NAME_LENGTH_EXCEEDED_EXCEPTION_MESSAGE);
    }
}
