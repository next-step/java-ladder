package nextstep.ladder.domain.exceptions;

public class NotExistPlayerNameException extends RuntimeException {
    public NotExistPlayerNameException(String message) {
        super(message);
    }
}
