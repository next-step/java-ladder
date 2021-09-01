package ladder.domain;

import ladder.exception.WinningItemsException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WinningItems {
    private final List<WinningItem> winningItems;

    public WinningItems(String[] itemsName) {
        validateWinningItems(itemsName);
        List<WinningItem> winningItems = new ArrayList<>();

        Arrays.stream(itemsName)
                .map(WinningItem::new)
                .forEach(winningItems::add);

        this.winningItems = winningItems;
    }

    private void validateWinningItems(String[] itemsName) {
        for (String item : itemsName) {
            if (item == null) {
                throw new WinningItemsException();
            }
        }
    }

    public WinningItem getItemToPosition(int position) {
        return winningItems.get(position);
    }

    public List<WinningItem> getWinningItems() {
        return Collections.unmodifiableList(winningItems);
    }
}
