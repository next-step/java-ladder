package ladder.domain.element;

public class PersonNameNotFoundException extends RuntimeException {
    public PersonNameNotFoundException(String name) {
        super(name);
    }
}
