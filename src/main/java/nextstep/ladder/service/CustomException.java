package nextstep.ladder.service;

public class CustomException extends IllegalArgumentException {

    public CustomException(String errorMsg) {
        super(errorMsg);
    }
}
