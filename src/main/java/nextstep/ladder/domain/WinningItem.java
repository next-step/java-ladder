package nextstep.ladder.domain;

import java.util.Objects;

public class WinningItem {

    private static final int NAME_MAX_LENGTH = 5;

    protected final String name;

    public WinningItem(String name) {
        nullCheck(name);

        name = name.trim();

        lengthCheck(name);

        this.name = name;
    }

    private void nullCheck(String name) {
        if (Objects.isNull(name) || name.isBlank()) {
            throw new IllegalArgumentException("당첨 항목을 입력해 주세요.");
        }
    }

    private void lengthCheck(String name) {
        if (NAME_MAX_LENGTH < name.length()) {
            throw new IllegalArgumentException("당첨 항목은 1~5자로 설정 하세요.");
        }
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WinningItem winningItem = (WinningItem) o;

        return Objects.equals(name, winningItem.name);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
