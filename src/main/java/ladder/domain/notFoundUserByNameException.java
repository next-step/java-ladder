package ladder.domain;


public class notFoundUserByNameException extends IllegalArgumentException {
    public notFoundUserByNameException(String message) {
        super(message);
    }
}
