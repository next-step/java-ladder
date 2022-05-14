package nextstep.ladder.domain;

public class User {
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public User(String name) {
        checkNullOrBlank(name);
        checkExceedMaxLength(name);
        this.name = name;
    }

    private void checkNullOrBlank(String name) {
        if (name == null || name.isEmpty()) {
            throw new CannotNullOrEmptyException();
        }
    }

    private void checkExceedMaxLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new ExceedMaxNameLengthException();
        }
    }

    public static class CannotNullOrEmptyException extends IllegalArgumentException {
        public CannotNullOrEmptyException() {
            super("null이거나 비어있을 수 없습니다.");
        }
    }

    public static class ExceedMaxNameLengthException extends IllegalArgumentException {
        public ExceedMaxNameLengthException() {
            super("이름 최대 길이를 초과했습니다.");
        }
    }

    @Override
    public String toString() {
        return this.name;
    }
}

