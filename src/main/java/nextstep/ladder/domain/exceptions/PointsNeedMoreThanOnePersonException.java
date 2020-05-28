package nextstep.ladder.domain.exceptions;

public class PointsNeedMoreThanOnePersonException extends RuntimeException {
    public PointsNeedMoreThanOnePersonException(String message) {
        super(message);
    }
}
