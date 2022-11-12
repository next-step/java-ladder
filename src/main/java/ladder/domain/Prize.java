package ladder.domain;

public class Prize {

    private final static String ERROR_EMPTY_VALUE = "입력 값이 누락되었습니다.";

    private final String name;

    public Prize(final String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(final String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException(ERROR_EMPTY_VALUE);
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
