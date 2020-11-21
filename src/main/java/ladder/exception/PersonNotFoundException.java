package ladder.exception;

public class PersonNotFoundException extends RuntimeException {
    private PersonNotFoundException() {
        super("존재하지 않는 사람입니다.");
    }

    public static PersonNotFoundException getInstance() {
        return SingletonHelper.instance;
    }

    private static class SingletonHelper {
        private static final PersonNotFoundException instance = new PersonNotFoundException();
    }
}
