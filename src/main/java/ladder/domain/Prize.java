package ladder.domain;

public class Prize {

    private final static String ERROR_EMPTY_VALUE = "입력 값이 누락되었습니다.";
    private final static String ERROR_NEGATIVE_VALUE = "0 이상의 값만 입력 가능합니다.";

    private final String name;
    private final int column;

    public Prize(final String name, final int column) {
        validateName(name);
        this.name = name;

        validateColumn(column);
        this.column = column;
    }

    private void validateName(final String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException(ERROR_EMPTY_VALUE);
        }
    }

    private void validateColumn(final int value) {
        if (value < 0) {
            throw new IllegalArgumentException(ERROR_NEGATIVE_VALUE);
        }
    }

    public boolean isSameColumn(final int column) {
        return this.column == column;
    }
}
