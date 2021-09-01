package ladder.domain;

import ladder.exception.WinningItemException;

public class WinningItem {
    private final String item;

    public WinningItem(String item) {
        validateItem(item);
        this.item = item;
    }

    private void validateItem(String item) {
        if (item == null || item.isEmpty()) {
            throw new WinningItemException();
        }
    }

    public String getItem() {
        return item;
    }
}
