package nextstep.ladder.domain.exceptions;

public class LocationLimitExceedException extends RuntimeException {
    public LocationLimitExceedException(String message) {
        super(message);
    }
}
