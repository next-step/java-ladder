package ladder.domain;

import ladder.exception.InvalidInputException;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class WinningItems {
    private static final String INVALID_WINNING_ITEMS_MESSAGE = "실행 결과의 갯수가 올바르지 않습니다.";

    private List<String> winningItems;

    public WinningItems(List<String> names, List<String> winningItems) {
        if (names.size() != winningItems.size()) {
            throw new InvalidInputException(INVALID_WINNING_ITEMS_MESSAGE);
        }
        this.winningItems = winningItems;
    }

    public String get(int index) {
        return winningItems.get(index);
    }

    public List<String> getWinningItems() {
        return Collections.unmodifiableList(winningItems);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningItems that = (WinningItems) o;
        return Objects.equals(winningItems, that.winningItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningItems);
    }
}
