package ladder.domain;

import ladder.exception.WinningItemsException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WinningItems {
    private final List<WinningItem> winningItems;

    public WinningItems(String[] itemsName) {
        validateWinningItems(itemsName);

        List<WinningItem> winningItems = new ArrayList<>();

        for (String item : itemsName) {
            WinningItem winningItem = new WinningItem(item);
            winningItems.add(winningItem);
        }
        this.winningItems = winningItems;
    }

    private void validateWinningItems(String[] itemsName) {
        for (String item : itemsName) {
            if (item == null) {
                throw new WinningItemsException();
            }
        }
    }

    public List<WinningItem> getWinningItems() {
        return Collections.unmodifiableList(winningItems);
    }
}
