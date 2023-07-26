package nextstep.ladder.domain;

import java.util.Objects;

public class WinningItem extends LadderItem {

    public static final String NULL_CHECK_ERROR_MESSAGE = "당첨 항목을 입력해 주세요.";
    public static final String LENGTH_CHECK_ERROR_MESSAGE = "당첨 항목은 1~5자로 설정 하세요.";

    public WinningItem(String name) {
        super(name);
    }

    @Override
    protected String nullCheckErrorMessage() {
        return NULL_CHECK_ERROR_MESSAGE;
    }

    @Override
    protected String lengthCheckErrorMessage() {
        return LENGTH_CHECK_ERROR_MESSAGE;
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
