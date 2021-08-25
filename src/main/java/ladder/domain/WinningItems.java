package ladder.domain;

import java.util.Collections;
import java.util.List;

public class WinningItems {
    private List<String> winningItems;

    public WinningItems(List<String> winningItems) {
        this.winningItems = winningItems;
    }

    public List<String> getWinningItems() {
        return Collections.unmodifiableList(winningItems);
    }
}
