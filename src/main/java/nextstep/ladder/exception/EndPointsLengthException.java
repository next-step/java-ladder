package nextstep.ladder.exception;

public class EndPointsLengthException extends RuntimeException {

    private static final String MINIMUM_END_POINTS_MESSAGE = "점수 개수는 사다리의 행 길이와 동일 해야합니다.";

    public EndPointsLengthException() {
        super(MINIMUM_END_POINTS_MESSAGE);
    }
}
