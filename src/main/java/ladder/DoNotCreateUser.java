package ladder;

public class DoNotCreateUser extends RuntimeException {

    public DoNotCreateUser(String message) {
        super(message);
    }
}
