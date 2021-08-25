package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class WinningItems {
    private List<String> winningItems;

    public WinningItems(List<String> winningItems) {
        this.winningItems = winningItems;
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
