package ladder.domain;

import java.util.Objects;

public class WinningCategory {

    private static final String PRINT_FORMAT = "%-5s ";
    private final String resultName;

    public WinningCategory(String resultName) {
        validateName(resultName);
        this.resultName = resultName;
    }

    public String getResultName() {
        return resultName;
    }

    private void validateName(String input) {
        if (Objects.isNull(input) || input.isEmpty()) {
            throw new IllegalArgumentException("결과값은 null이거나 공백일 수 없습니다");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof WinningCategory)) {
            return false;
        }

        WinningCategory that = (WinningCategory) o;

        return Objects.equals(resultName, that.resultName);
    }

    @Override
    public int hashCode() {
        return resultName != null ? resultName.hashCode() : 0;
    }

    @Override
    public String toString() {
        return String.format(PRINT_FORMAT, this.resultName);
    }
}
